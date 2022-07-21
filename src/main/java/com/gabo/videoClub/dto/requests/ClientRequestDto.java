package com.gabo.videoClub.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientRequestDto {

    @NotBlank(message = "The field is required")
    private String nombre;

    @NotBlank(message = "The field is required")
    private String email;

    @NotNull(message = "The field is required")
    private LocalDate birthDate;

}
