package ru.autohelp.server.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@Tag(name = "REST Controller", description = "REST API Controller")
@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private HistoryRepository historyRepository;

    @Operation(summary = "get all clients", description = "allows to get all clients that exist in the database")
    @GetMapping("/clients")
    public List<Client> showAllClients(){
        return clientService.getAllClients();
    }

    @Operation(summary = "get any client", description = "allows to get any client that exists in the database")
    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable @Parameter(description = "client id") int id){
        Client client = clientService.getClient(id);
        if(client == null)
            throw new NoSuchClientException("There is no client with ID = " + id + " in Database");
        return client;
    }

    @Operation(summary = "add new client", description = "allows to save new client in the database")
    @PostMapping("/clients")
    public Client addNewClient(@RequestBody Client client){
        clientService.saveClient(client);
        return client;
    }

    @Operation(summary = "update client", description = "allows to update any client that exists in the database")
    @PutMapping("/clients")
    public Client updateClient(@RequestBody Client client){
        clientService.saveClient(client);
        return client;
    }

    @Operation(summary = "delete client", description = "allows to delete any client that exists in the database")
    @DeleteMapping("/clients/{id}")
    public String deleteClient(@PathVariable @Parameter(description = "client id") int id){
        Client client = clientService.getClient(id);
        if(client == null)
            throw new NoSuchClientException("There is no client with ID = " + id + " in Database");
        clientService.deleteClient(id);
        return "Client with ID = " + id + " was deleted";
    }

    @Operation(summary = "get all histories", description = "allows to get all service histories that exist in the database")
    @GetMapping("/history")
    public List<History> showAllHistory(){
        return (List<History>) historyRepository.findAll();
    }

    @Operation(summary = "get any history", description = "allows to get any service history that exists in the database")
    @GetMapping("/history/{id}")
    public History getHistory(@PathVariable @Parameter(description = "history id") int id){
        Optional<History> history = historyRepository.findById(id);
        if(history.isEmpty())
            throw new NoSuchClientException("There is no history with ID = " + id + " in Database");
        return history.get();
    }
}
