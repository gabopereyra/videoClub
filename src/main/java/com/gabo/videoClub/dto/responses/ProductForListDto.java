package com.gabo.videoClub.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForListDto {
    private String name;

    private String classType;

    private String link;
}
