package kz.onelab.onelabsamples.controller;

import kz.onelab.onelabsamples.db.ClientDb;
import kz.onelab.onelabsamples.dto.ClientSaveRequestDto;
import kz.onelab.onelabsamples.entity.Client;
import kz.onelab.onelabsamples.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService; // immutable

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // github ->
    // Project -> Project Name
    // 1. Controller(Get, POst, Put, Delete), Service(methods), DB
    // 2. Improvements

    // http://localhost:8080/byName?name=Abylay

    @PostMapping(value = "/save")
    public ResponseEntity<Client> saveClientByName(@RequestBody ClientSaveRequestDto requestDto) {
        String name = requestDto.getName();
        if (name == null || name.isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        Client client = new Client();
        client.setName(name);
        clientService.addClient(client);
        return ResponseEntity.ok(client);
    }

    @GetMapping(value = "/byName")
    public ResponseEntity<Client> findClientByName(@RequestParam(name = "name") String name) {
        Client clientByName = clientService.getClientByName(name);
        return ResponseEntity.ok(clientByName);
    }

    @DeleteMapping(value = "/byName") // 200, 404
    public ResponseEntity<Void> deleteClient(@RequestParam(name = "name") String name) {
        clientService.deleteClientByName(name);
        return ResponseEntity.ok().build();
    }

}

// http://localhost:8080
