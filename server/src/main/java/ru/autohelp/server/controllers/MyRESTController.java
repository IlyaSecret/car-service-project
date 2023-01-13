package ru.autohelp.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.autohelp.server.dao.HistoryRepository;
import ru.autohelp.server.exception_handling.NoSuchClientException;
import ru.autohelp.server.models.Client;
import ru.autohelp.server.models.History;
import ru.autohelp.server.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private HistoryRepository historyRepository;

    @GetMapping("/clients")
    public List<Client> showAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable int id){
        Client client = clientService.getClient(id);
        if(client == null)
            throw new NoSuchClientException("There is no client with ID = " + id + " in Database");
        return client;
    }

    @PostMapping("/clients")
    public Client addNewClient(@RequestBody Client client){
        clientService.saveClient(client);
        return client;
    }

    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client client){
        clientService.saveClient(client);
        return client;
    }

    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable int id){
        Client client = clientService.getClient(id);
        if(client == null)
            throw new NoSuchClientException("There is no client with ID = " + id + " in Database");
        clientService.deleteClient(id);
        return "Client with ID = " + id + " was deleted";
    }

    @GetMapping("/history")
    public List<History> showAllHistory(){
        return (List<History>) historyRepository.findAll();
    }

    @GetMapping("/history/{id}")
    public History getHistory(@PathVariable int id){
        Optional<History> history = historyRepository.findById(id);
        if(history.isEmpty())
            throw new NoSuchClientException("There is no history with ID = " + id + " in Database");
        return history.get();
    }
}
