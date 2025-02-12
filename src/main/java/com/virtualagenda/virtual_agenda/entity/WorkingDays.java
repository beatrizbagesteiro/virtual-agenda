package com.virtualagenda.virtual_agenda.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.virtualagenda.virtual_agenda.dto.WorkingDaysDTO;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dayOfWeek;
    private LocalTime openingHour;
    private LocalTime closingHour;

    public WorkingDays(WorkingDaysDTO data){
        this.id = data.id();
        this.dayOfWeek = data.dayOfWeek();
        this.openingHour = data.openingHour();
        this.closingHour = data.closingHour();
    }
}
