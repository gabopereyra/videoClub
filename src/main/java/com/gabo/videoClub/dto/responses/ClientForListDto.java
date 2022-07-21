package com.gabo.videoClub.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientForListDto{
    private String nombre;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate clientSince;

    private String link;
}
