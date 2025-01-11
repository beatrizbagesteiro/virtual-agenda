package com.virtualagenda.virtual_agenda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Table(name = "application_user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;
    private String email;
    private String password;
    private String phoneNumber;

    @ManyToMany
    @JoinTable(
            name = "professional_services",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> services;

    @OneToMany(mappedBy = "professional")
    private List<Appointment> professionalAppointments;
    @OneToMany(mappedBy = "client")
    private List<Appointment> clientAppointments;

}
