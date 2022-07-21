package com.gabo.videoClub.dto.responses;

import com.gabo.videoClub.enums.ClasificationPerAge;
import com.gabo.videoClub.enums.MovieStorageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDto {
    private String name;

    private Integer totalQuantity;

    private Integer borrowQuantity;

    private ClasificationPerAge clasificationPerAge;

    private Short duration;

    private MovieStorageType movieStorageType;
}
