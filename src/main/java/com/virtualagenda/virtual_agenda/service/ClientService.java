package com.virtualagenda.virtual_agenda.service;

import com.virtualagenda.virtual_agenda.dto.ClientDTO;
import com.virtualagenda.virtual_agenda.entity.User;
import com.virtualagenda.virtual_agenda.entity.UserType;
import com.virtualagenda.virtual_agenda.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final UserRepository repository;

    public ClientService(UserRepository userRepository){
        this.repository = userRepository;
    }

    public List<User> getClients(){
        return repository.findByUserType(UserType.CLIENT);
    }

    public String updateClient(ClientDTO data){
        User user = repository.getReferenceById(data.id());
        user.setName(data.name());
        user.setEmail(data.email());
        user.setPassword(data.password());
        repository.save(user);
        return "Client updated successfully";
    }

    public String deleteClient(ClientDTO data){
        User user = repository.getReferenceById(data.id());
        repository.delete(user);
        return "Client deleted successfully";
    }
}
