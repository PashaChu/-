package com.example.System.controller;

import com.example.System.entity.Client;
import com.example.System.exception.UserNotFoundException;
import com.example.System.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/clients/table")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        try {
            return ResponseEntity.ok(clientService.saveClient(client));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping
    public ResponseEntity<?> updateClient(@RequestBody Client client) {
        try {
            return ResponseEntity.ok().body(clientService.updateClient(client));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity<?> getClients() {
        try {
            return ResponseEntity.ok().body(clientService.findAllClient());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/equal")
    public ResponseEntity<?> getOneClient(@PathVariable String login, @PathVariable String password) {
        System.out.println(login  + " " + password);
        try {
            return ResponseEntity.ok().body(clientService.getOneClient(login, password));
        } catch (UserNotFoundException | Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable Long id) {
        try {
            return ResponseEntity.ok().body(clientService.deleteClient(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
