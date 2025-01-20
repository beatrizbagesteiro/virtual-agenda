package com.virtualagenda.virtual_agenda.entity;

import com.virtualagenda.virtual_agenda.dto.ServiceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "establishment_service")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class EstablishmentService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer duration;

    @ManyToMany(mappedBy = "establishmentServices")
    private List<User> professionals;

    public EstablishmentService(ServiceDTO serviceDTO){
        this.name = serviceDTO.name();
        this.duration = serviceDTO.duration();
        this.price = serviceDTO.price();
    }

}


