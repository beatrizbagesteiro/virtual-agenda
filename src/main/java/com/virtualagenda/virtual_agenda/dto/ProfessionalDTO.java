package com.virtualagenda.virtual_agenda.dto;
import jakarta.validation.constraints.*;

import java.util.List;

public record ProfessionalDTO(
        Long id,
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password must have at least 8 characters, including uppercase, lowercase, number, and special character")
        String password,
        @NotNull
        Long establishmentId,
        @NotNull
        @Size(min = 1, message = "At least one Service ID must be provided")
        List<Long> servicesIds ) {


}
