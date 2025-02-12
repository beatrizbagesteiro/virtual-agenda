package com.virtualagenda.virtual_agenda.controller;

import com.virtualagenda.virtual_agenda.dto.WorkingDaysDTO;
import com.virtualagenda.virtual_agenda.entity.WorkingDays;
import com.virtualagenda.virtual_agenda.service.WorkingDaysService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/working_days")
public class WorkingDaysController {
    @Autowired
    public WorkingDaysService service;

    @GetMapping
    public ResponseEntity<List<WorkingDays>> getWorkingDays(){
        return ResponseEntity.ok(service.getWorkingDays());
    }

    @PostMapping
    public ResponseEntity<String> registerWorkingDay(@RequestBody @Valid WorkingDaysDTO data){
        String response = service.registerWorkingDay(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping
    public ResponseEntity<String> updateWorkingDay(@RequestBody @Valid WorkingDaysDTO data){
        String response = service.updateWorkingDay(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteWorkingDay(@RequestBody @Valid WorkingDaysDTO data){
        String response = service.deleteWorkingDay(data);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
