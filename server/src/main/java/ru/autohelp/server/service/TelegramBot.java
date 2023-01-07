package ru.autohelp.server.service;

import com.vdurmont.emoji.EmojiParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.autohelp.server.config.BotConfig;
import ru.autohelp.server.models.Ads;
import ru.autohelp.server.models.Client;
import ru.autohelp.server.repository.AdsRepository;

import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot{

    @Autowired
    private ClientService clientService;

    @Autowired
    private AdsRepository adsRepository;

    private final BotConfig config;

    private static final String HELP_TEXT = "Этот бот создан для упрощения создания заявки на тех. осмотр. \n" +
            "Вы можете использовать команды из главного меню для ознакомления с возможностями бота";

    private static final String YES_BUTTON = "YES_BUTTON";
    private static final String NO_BUTTON = "NO_BUTTON";
    private static final String ERROR_TEXT = "Error occurred: ";

    public TelegramBot(BotConfig config){
        this.config = config;
        List<BotCommand> listOfCommands = new ArrayList<>();
        listOfCommands.add(new BotCommand("/start", "начать работу с ботом"));
        listOfCommands.add(new BotCommand("/register", "регистрация своих данных в систему"));
        listOfCommands.add(new BotCommand("/send", "рассылка сообщения всем пользователям"));
        listOfCommands.add(new BotCommand("/mydata", "получить данные о себе из системы"));
        listOfCommands.add(new BotCommand("/deletedata", "удалить свои данные из системы"));
        listOfCommands.add(new BotCommand("/help", "информация как пользоваться ботом"));
        listOfCommands.add(new BotCommand("/settings", "настроить систему под себя"));
        try{
            this.execute(new SetMyCommands(listOfCommands, new BotCommandScopeDefault(), null));
        }
        catch (TelegramApiException e){
            log.error("Error setting bot's command list: " + e.getMessage());
        }
    }

    @Override
    public String getBotUsername() {
        return config.getBotUsername();
    }

    @Override
    public String getBotToken() {
        return config.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            Client currentClient = clientService.getClient((int) chatId);

            if(messageText.contains("/send") && currentClient.getRole().equals("admin")){
                var textToSend = EmojiParser.parseToUnicode(messageText.substring(messageText.indexOf(" ")));
                var clients = clientService.getAllClients();
                for(Client client : clients){
                    sendMessage(client.getId(), textToSend);
                }
                String answer = EmojiParser.parseToUnicode("Сообщение успешно отправлено! :slight_smile: ");
                sendMessage(chatId, answer);
            }

            else {
                switch (messageText) {
                    case "/start":
                        registerUser(update.getMessage());
                        startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                        break;
                    case "/help":
                        sendMessage(chatId, HELP_TEXT);
                        break;
                    case "/register":
                    case "зарегистрироваться":
                        register(chatId);
                        break;
                    case "/send":
                        break;
                    case "/mydata":
                    case "проверить мои данные":
                        if(clientService.getClient((int) chatId) == null)
                            sendMessage(chatId, EmojiParser.parseToUnicode("Ваши отсутствуют в системе :grimacing:"));
                        else{
                            sendMessage(chatId, "Ваши данные: \n");
                            sendMessage(chatId, clientService.getClient((int) chatId).toString());
                        }
                        break;
                    case "/deletedata":
                    case "удалить мои данные":
                        clientService.deleteClient((int) chatId);
                        sendMessage(chatId, EmojiParser.parseToUnicode("Ваши данные успешно удалены из системы! :smile:"));
                        break;
                    case "записаться на ТО":
                        if(clientService.getClient((int) chatId) == null)
                            sendMessage(chatId, EmojiParser.parseToUnicode("Чтобы записаться на ТО, Вы должны быть авторизованы в системе :face_with_monocle:"));
                        else
                            sendMessage(chatId, EmojiParser.parseToUnicode("Вы были успешно записаны на ТО :wink:"));
                        break;
                    case "подписаться на рассылку":
                        if(clientService.getClient((int) chatId) == null)
                            sendMessage(chatId, EmojiParser.parseToUnicode("Чтобы подпписаться на рассылку, Вы должны быть авторизованы в системе :face_with_monocle:"));
                        else
                            sendMessage(chatId, EmojiParser.parseToUnicode("Вы успешно подписались на рассылку :grin:"));
                        break;
                    default:
                        sendMessage(chatId, EmojiParser.parseToUnicode("Извините, команда не распознана  :pensive:"));
                }
            }
        }
        else if(update.hasCallbackQuery()){
            String callbackData = update.getCallbackQuery().getData();
            int messageId = update.getCallbackQuery().getMessage().getMessageId();
            long chatId = update.getCallbackQuery().getMessage().getChatId();

            if(callbackData.equals(YES_BUTTON)){
                registerUser(update.getCallbackQuery().getMessage());
                String text = EmojiParser.parseToUnicode("Вы были успешно зарегистрированы в системе :wink:");
                executeEditMessageText(text, chatId, messageId);
            }
            else if(callbackData.equals(NO_BUTTON)){
                String text = EmojiParser.parseToUnicode("Регистрация в системе отменена :confused:");
                executeEditMessageText(text, chatId, messageId);
            }
        }
    }

    private void executeEditMessageText(String text, long chatId, int messageId){
        EditMessageText message = new EditMessageText();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        message.setMessageId(messageId);

        try{
            execute(message);
        }
        catch (TelegramApiException e){
            log.error(ERROR_TEXT + e.getMessage());
        }
    }

    private void startCommandReceived(long charId, String name){
        String greeting = "Привет, " + name + ", рады видеть тебя!";
        String answer = EmojiParser.parseToUnicode(greeting + " :blush:");
        log.info("Replied to user " + name);
        sendMessageToStart(charId, answer);
    }

    private void sendMessage(long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        executeMessage(message);
    }

    private void sendMessageToStart(long chatId, String textToSend){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        message.setReplyMarkup(getKeyboard());

        executeMessage(message);
    }

    private void registerUser(Message message){
        var currentClient = clientService.getClient(message.getChatId().intValue());
        if(currentClient == null){
            var chatId = message.getChatId();
            var chat = message.getChat();
            Client client = new Client();
            client.setId(Math.toIntExact(chatId));
            client.setFullName(chat.getFirstName() + " " + chat.getLastName());

            client.setContact(chat.getUserName());
            client.setRole("user");
            client.setPassword("12345");

            clientService.saveClient(client);
            log.info("Client saved: " + client);
        }
        else
            sendMessage(message.getChatId(), EmojiParser.parseToUnicode("Вы уже зарегистрированы в системе! :smile:"));
    }

    private void register(long chatId){
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText("Вы точно хотите зарегистрироваться?");
        InlineKeyboardMarkup markupInLine = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        var yesButton = new InlineKeyboardButton();
        yesButton.setText("Да");
        yesButton.setCallbackData(YES_BUTTON);

        var noButton = new InlineKeyboardButton();
        noButton.setText("Нет");
        noButton.setCallbackData(NO_BUTTON);

        rowInLine.add(yesButton);
        rowInLine.add(noButton);

        rowsInLine.add(rowInLine);

        markupInLine.setKeyboard(rowsInLine);
        message.setReplyMarkup(markupInLine);

        executeMessage(message);
    }

    private ReplyKeyboardMarkup getKeyboard(){
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();
        KeyboardRow row = new KeyboardRow();
        row.add("записаться на ТО");
        row.add("подписаться на рассылку");
        keyboardRows.add(row);
        row = new KeyboardRow();
        row.add("зарегистрироваться");
        row.add("проверить мои данные");
        row.add("удалить мои данные");
        keyboardRows.add(row);
        keyboardMarkup.setKeyboard(keyboardRows);
        return keyboardMarkup;
    }

    private void executeMessage(SendMessage message){
        try{
            execute(message);
        }
        catch (TelegramApiException e){
            log.error(ERROR_TEXT + e.getMessage());
        }
    }

    @Scheduled(cron = "0 * * * * *")
    private void sendAds(){
        var ads = adsRepository.findAll();
        var clients = clientService.getAllClients();
        for(Ads ad : ads){
            for(Client client : clients){
                sendMessage(client.getId(), ad.getAd());
            }
        }
    }
}
