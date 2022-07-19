package com.gabo.videoClub.mappers;

import com.gabo.videoClub.dto.requests.MovieRequestDto;
import com.gabo.videoClub.entities.Movie;
import org.mapstruct.Mapper;

@Mapper
public interface IMovieMapper {
    Movie movieRequestToMovie(MovieRequestDto movieRequestDto);


}