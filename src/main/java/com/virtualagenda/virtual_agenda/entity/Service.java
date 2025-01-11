package com.virtualagenda.virtual_agenda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "service")
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double price;
    private Integer duration;

    @ManyToMany(mappedBy = "services")
    private List<User> professionals;
}
