package com.virtualagenda.virtual_agenda.service;

import com.virtualagenda.virtual_agenda.dto.ServiceDTO;
import com.virtualagenda.virtual_agenda.entity.EstablishmentService;
import com.virtualagenda.virtual_agenda.repository.EstablishmentServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentServiceService {

    private final EstablishmentServiceRepository establishmentServiceRepository;

    public EstablishmentServiceService(EstablishmentServiceRepository establishmentServiceRepository) {
        this.establishmentServiceRepository = establishmentServiceRepository;
    }

    public List<EstablishmentService> getAllServices(){
        return establishmentServiceRepository.findAll();
    }

    public String registerService(ServiceDTO data){
        EstablishmentService newService = new EstablishmentService(data);
        establishmentServiceRepository.save(newService);
        return "Service registered successfully";
    }

    public String updateService(ServiceDTO data){
        EstablishmentService establishmentService = establishmentServiceRepository.getReferenceById(data.id());
        establishmentService.setName(data.name());
        establishmentService.setDuration(data.duration());
        establishmentService.setPrice(data.price());
        establishmentServiceRepository.save(establishmentService);
        return "Service updated successfully";
    }

    public String deleteService(ServiceDTO data){
        EstablishmentService establishmentService = establishmentServiceRepository.getReferenceById(data.id());
        establishmentServiceRepository.delete(establishmentService);
        return "Service deleted successfully";
    }

}
