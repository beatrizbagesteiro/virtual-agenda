package com.virtualagenda.virtual_agenda.controller;

import com.virtualagenda.virtual_agenda.dto.AuthDTO;
import com.virtualagenda.virtual_agenda.dto.LoginResponseDTO;
import com.virtualagenda.virtual_agenda.dto.RegisterDTO;
import com.virtualagenda.virtual_agenda.entity.User;
import com.virtualagenda.virtual_agenda.infra.security.TokenService;
import com.virtualagenda.virtual_agenda.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService service;

    @Autowired
    TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data){
        var userNamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(userNamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity registerClient(@RequestBody @Valid RegisterDTO data){
        ResponseEntity response = service.register(data);
        return ResponseEntity.ok().body(response);
    }
}
