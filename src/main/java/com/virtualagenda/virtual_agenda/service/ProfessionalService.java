package com.virtualagenda.virtual_agenda.service;

import com.virtualagenda.virtual_agenda.dto.ProfessionalDTO;
import com.virtualagenda.virtual_agenda.entity.EstablishmentService;
import com.virtualagenda.virtual_agenda.entity.User;
import com.virtualagenda.virtual_agenda.entity.UserType;
import com.virtualagenda.virtual_agenda.repository.EstablishmentServiceRepository;
import com.virtualagenda.virtual_agenda.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalService {
    private final UserRepository repository;
    private final EstablishmentServiceRepository serviceRepository;
    public ProfessionalService(UserRepository repository, EstablishmentServiceRepository serviceRepository){
        this.repository = repository;
        this.serviceRepository = serviceRepository;
    }

    public List<User> getProfessionals(){
        return repository.findByUserType(UserType.PROFESSIONAL);
    }


    public String updateProfessional(ProfessionalDTO data){
        User user = repository.getReferenceById(data.id());
        user.setName(data.name());
        user.setPassword(data.password());
        user.setEmail(data.email());
        List<EstablishmentService> services = serviceRepository.findAllById(data.servicesIds());
        user.setEstablishmentServices(services);
        repository.save(user);
        return "Professional updated successfully";
    }

    public String deleteProfessional(ProfessionalDTO data){
        User user = repository.getReferenceById(data.id());
        repository.delete(user);
        return "Professional deleted successfully";
    }
}
