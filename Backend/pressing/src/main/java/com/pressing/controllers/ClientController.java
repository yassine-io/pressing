package com.pressing.controllers;


import com.pressing.models.ClientEntity;
import com.pressing.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public List<ClientEntity> getAllClients() {
        return clientService.getAllClient();
    }

    @PostMapping
    public ClientEntity addClient(@RequestBody ClientEntity client) {
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.deleteClient(id);
    }



}
