package com.virtualagenda.virtual_agenda.service;

import com.virtualagenda.virtual_agenda.dto.RegisterDTO;
import com.virtualagenda.virtual_agenda.entity.User;
import com.virtualagenda.virtual_agenda.entity.UserType;
import com.virtualagenda.virtual_agenda.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private final UserRepository repository;

    public AuthService(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    public ResponseEntity register(RegisterDTO data){
        if(repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data);
        if(data.userType() == null){newUser.setUserType(UserType.CLIENT);}
        newUser.setPassword(encryptedPassword);
        repository.save(newUser);
        return ResponseEntity.ok().body("User created successfully");
    }
}
