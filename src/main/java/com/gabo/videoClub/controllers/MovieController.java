package com.gabo.videoClub.controllers;

import com.gabo.videoClub.dto.requests.MovieRequestDto;
import com.gabo.videoClub.dto.responses.MovieResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.services.IGameService;
import com.gabo.videoClub.services.IMovieService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private IMovieService movieService;

    public MovieController(IMovieService movieService) {
       this.movieService = movieService;
    }

    @PostMapping("/movies")
    public ResponseEntity<EntityModel<ResponseInfo>> createMovie(@Valid @RequestBody MovieRequestDto movie){
        return movieService.saveMovie(movie);
    }

    @GetMapping(value = "/movies/{id}")
    public ResponseEntity<EntityModel<MovieResponseDto>> getMovieById(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieResponseDto>> getAllMovies(){
        return null;
    }

    @DeleteMapping(value = "/movies/{id}")
    public ResponseEntity<ResponseInfo> deleteMovieById(@PathVariable Integer id) {
        return null;
    }
}
