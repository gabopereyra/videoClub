package com.gabo.videoClub.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRequestDto {

    @NotNull(message = "The field is required")
    private Integer id_client;

    @NotNull(message = "The field is required")
    private List<Integer> products;


}
