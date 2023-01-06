package ru.autohelp.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.autohelp.server.exception_handling.NoSuchClientException;
import ru.autohelp.server.models.Client;
import ru.autohelp.server.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private ClientService clientService;

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
}
