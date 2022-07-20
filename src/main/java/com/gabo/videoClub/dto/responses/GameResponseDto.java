package com.gabo.videoClub.dto.responses;

import com.gabo.videoClub.enums.ClasificationPerAge;
import com.gabo.videoClub.enums.Console;
import com.gabo.videoClub.enums.MovieStorageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameResponseDto {
    private String name;

    private Integer totalQuantity;

    private Integer borrowQuantity;

    private ClasificationPerAge clasificationPerAge;

    private Console console;
}
