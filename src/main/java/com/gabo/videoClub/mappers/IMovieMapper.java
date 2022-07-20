package com.gabo.videoClub.mappers;

import com.gabo.videoClub.controllers.MovieController;
import com.gabo.videoClub.dto.requests.MovieRequestDto;
import com.gabo.videoClub.dto.responses.MovieForListDto;
import com.gabo.videoClub.dto.responses.MovieResponseDto;
import com.gabo.videoClub.entities.Movie;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper
public interface IMovieMapper {
    Movie movieRequestToMovie(MovieRequestDto movieRequestDto);

    MovieResponseDto movieToMovieResponseDto(Movie movie);

    @BeforeMapping
    default void setLink(Movie movie, @MappingTarget MovieForListDto movieForListDto) {
        Integer id = movie.getId();
        movieForListDto.setLink(linkTo(methodOn(MovieController.class).getMovieById(id)).toString());
    }
    MovieForListDto movieToMovieForListDto(Movie movie);

    List<MovieForListDto> movieToListDto(List<Movie> movie);
}