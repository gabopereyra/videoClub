package com.gabo.videoClub.services.impl;

import com.gabo.videoClub.controllers.MovieController;
import com.gabo.videoClub.controllers.ProductController;
import com.gabo.videoClub.dto.requests.MovieRequestDto;
import com.gabo.videoClub.dto.responses.MovieForListDto;
import com.gabo.videoClub.dto.responses.MovieResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.entities.Movie;
import com.gabo.videoClub.mappers.IMovieMapper;
import com.gabo.videoClub.repositories.IMovieRepository;
import com.gabo.videoClub.services.IMovieService;
import org.mapstruct.factory.Mappers;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class MovieServiceImpl implements IMovieService {
    private IMovieRepository movieRepository;

    IMovieMapper movieMapper = Mappers.getMapper(IMovieMapper.class);

    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Link getSelfLink(Integer id) {
        return linkTo(methodOn(MovieController.class).getMovieById(id)).withRel("Show movie:");
    }

    @Override
    public Link getCollectionLink() {
        return linkTo(methodOn(MovieController.class).getAllMovies()).withRel("Show all movies:");
    }

    @Override
    public Link getDeleteLink(Integer id) {
        return linkTo(methodOn(MovieController.class).deleteMovieById(id)).withRel("Delete movie:");
    }

    @Override
    public ResponseEntity<EntityModel<ResponseInfo>> saveMovie(MovieRequestDto movieRequestDto) {
        Movie movie = movieMapper.movieRequestToMovie(movieRequestDto);

        Integer id = movieRepository.save(movie).getId();

        ResponseInfo response = new ResponseInfo("Movie created successfully.", HttpStatus.CREATED.value());

        return ResponseEntity.status(HttpStatus.CREATED).body(EntityModel.of(response, this.getSelfLink(id), this.getCollectionLink()));
    }

    @Override
    public List<MovieForListDto> getAllMovies() {
        return null;
    }

    @Override
    public MovieResponseDto getMovieById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseInfo> deleteMovie(Integer id) {
        return null;
    }
}
