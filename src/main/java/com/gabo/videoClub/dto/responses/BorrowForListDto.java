package com.gabo.videoClub.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowForListDto {
    private String clientName;
    private LocalDate finalizationDate;
    private Integer totalProducts;
    private String link;
}
