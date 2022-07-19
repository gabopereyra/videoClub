package com.gabo.videoClub.services;

import com.gabo.videoClub.dto.requests.MovieRequestDto;
import com.gabo.videoClub.dto.responses.MovieForListDto;
import com.gabo.videoClub.dto.responses.MovieResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovieService extends IHateoas <Integer>{
    public ResponseEntity<EntityModel<ResponseInfo>> saveMovie(MovieRequestDto movieRequestDto);
    public List<MovieForListDto> getAllMovies();
    public ResponseEntity<EntityModel<MovieResponseDto>> getMovieById(Integer id);
    public ResponseEntity<ResponseInfo> deleteMovie(Integer id);

}
