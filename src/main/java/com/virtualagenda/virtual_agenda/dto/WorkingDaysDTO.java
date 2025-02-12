package com.virtualagenda.virtual_agenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record WorkingDaysDTO(
        Long id,
        @NotNull
        Long establishmentId,
        @NotBlank
        String dayOfWeek,
        @NotNull
        LocalTime openingHour,
        @NotNull
        LocalTime closingHour
) {
}
