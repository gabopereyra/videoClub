package com.gabo.videoClub.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowResponseDto {
    private ClientForListDto client;
    private Boolean isOver;
    private LocalDate finalizationDate;
    private List<ProductForListDto> products;

}
