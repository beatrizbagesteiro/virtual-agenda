package com.virtualagenda.virtual_agenda.controller;

import com.virtualagenda.virtual_agenda.dto.ProfessionalDTO;
import com.virtualagenda.virtual_agenda.entity.User;
import com.virtualagenda.virtual_agenda.service.ProfessionalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/professional")
public class ProfessionalController {

    @Autowired
    private ProfessionalService service;

    @GetMapping
    public ResponseEntity<List<User>> getProfessionals(){
        return ResponseEntity.ok(service.getProfessionals());
    }

    @PostMapping
    public ResponseEntity<String> registerProfessional(@RequestBody @Valid ProfessionalDTO data){
        String response = service.registerProfessional(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<String> updateProfessional(@RequestBody @Valid ProfessionalDTO data){
        String response = service.updateProfessional(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteProfessional(@RequestBody @Valid ProfessionalDTO data){
        String response = service.deleteProfessional(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
