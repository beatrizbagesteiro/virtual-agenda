package com.virtualagenda.virtual_agenda.controller;

import com.virtualagenda.virtual_agenda.dto.ClientDTO;
import com.virtualagenda.virtual_agenda.entity.User;
import com.virtualagenda.virtual_agenda.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    public ClientService service;

    @GetMapping
    public ResponseEntity<List<User>> getClients(){
        return ResponseEntity.ok(service.getClients());
    }

    @PostMapping
    public ResponseEntity<String> registerClient(@RequestBody @Valid ClientDTO data){
        String response = service.registerClient(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<String> updateClient(@RequestBody @Valid ClientDTO data){
        String response = service.updateClient(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteClient(@RequestBody @Valid ClientDTO data){
        String response = service.deleteClient(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
