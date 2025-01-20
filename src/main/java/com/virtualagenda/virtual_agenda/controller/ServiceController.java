package com.virtualagenda.virtual_agenda.controller;

import com.virtualagenda.virtual_agenda.dto.ServiceDTO;
import com.virtualagenda.virtual_agenda.entity.EstablishmentService;
import com.virtualagenda.virtual_agenda.service.EstablishmentServiceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private EstablishmentServiceService service;

    @GetMapping
    public ResponseEntity<List<EstablishmentService>> getAllServices(){
        return ResponseEntity.ok(service.getAllServices());
    }

    @PostMapping
    public ResponseEntity<String> registerService(@RequestBody @Valid ServiceDTO data){
        String response = service.registerService(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<String> updateService(@RequestBody @Valid ServiceDTO data){
        String response = service.updateService(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteService(@RequestBody @Valid ServiceDTO data){
        String response = service.deleteService(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
