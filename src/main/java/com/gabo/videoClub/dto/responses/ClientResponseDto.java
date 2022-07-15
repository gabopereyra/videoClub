package com.gabo.videoClub.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private Integer id;

    private String nombre;

    private String email;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate clientSince;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthDate;
}
