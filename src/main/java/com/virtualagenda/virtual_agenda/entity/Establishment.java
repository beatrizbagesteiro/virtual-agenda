package com.virtualagenda.virtual_agenda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "establishment")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Establishment {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;


    @OneToMany(mappedBy = "establishment")
    private List<User> users;

    @OneToMany(mappedBy = "establishment")
    private List<WorkingDays> workingDays;


}
