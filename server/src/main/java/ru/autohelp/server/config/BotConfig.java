package ru.autohelp.server.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("classpath:application.properties")
public class BotConfig {

    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

}
