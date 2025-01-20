package com.virtualagenda.virtual_agenda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalTime;

@Table(name = "working_days")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkingDays {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "establishment_id")
    private Establishment establishment;

    private String dayOfWeek;
    private LocalTime openingHour;
    private LocalTime closingHour;

}
