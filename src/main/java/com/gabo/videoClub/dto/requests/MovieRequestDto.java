package com.gabo.videoClub.dto.requests;

import com.gabo.videoClub.entities.ClasificationPerAge;
import com.gabo.videoClub.entities.MovieStorageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequestDto {

    @NotBlank(message = "The field is required")
    private String name;

    @NotNull(message = "The field is required")
    private Integer totalQuantity;

    @NotNull(message = "The field is required")
    private ClasificationPerAge clasificationPerAge;

    @NotNull(message = "The field is required")
    private Short duration;

    @NotNull(message = "The field is required")
    private MovieStorageType movieStorageType;
}