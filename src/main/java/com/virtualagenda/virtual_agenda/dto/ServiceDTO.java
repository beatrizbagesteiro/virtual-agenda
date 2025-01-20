package com.virtualagenda.virtual_agenda.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ServiceDTO(
        Long id,
        @NotBlank
        String name,
        @NotNull
        Integer duration,
        @NotNull
        Double price) {

}