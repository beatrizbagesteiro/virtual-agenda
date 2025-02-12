package com.virtualagenda.virtual_agenda.dto;

import com.virtualagenda.virtual_agenda.entity.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterDTO(
        Long id,
        @NotBlank
        String name,
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password must have at least 8 characters, including uppercase, lowercase, number, and special character")
        String password,
        UserType userType
) {
}
