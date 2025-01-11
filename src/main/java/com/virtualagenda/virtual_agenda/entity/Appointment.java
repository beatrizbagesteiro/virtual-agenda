package com.virtualagenda.virtual_agenda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalTime;

@Table(name = "appointment")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "professional_id")
    private User professional;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
    private LocalDate date;
    private LocalTime time;

    private AppointmentStatus status;

}
