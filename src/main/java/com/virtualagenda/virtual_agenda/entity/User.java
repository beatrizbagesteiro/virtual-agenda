package com.virtualagenda.virtual_agenda.entity;

import com.virtualagenda.virtual_agenda.dto.ClientDTO;
import com.virtualagenda.virtual_agenda.dto.ProfessionalDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.List;


@Table(name = "application_user")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private UserType userType;
    @ManyToOne
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;
    private String email;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "professional_services",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<EstablishmentService> establishmentServices;

    @OneToMany(mappedBy = "professional")
    private List<Appointment> professionalAppointments;
    @OneToMany(mappedBy = "client")
    private List<Appointment> clientAppointments;

    public User(ProfessionalDTO data){
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
    }

    public User(ClientDTO data){
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
    }
}
