package com.gabo.videoClub.services.impl;

import com.gabo.videoClub.controllers.ProductController;
import com.gabo.videoClub.dto.requests.GameRequestDto;
import com.gabo.videoClub.dto.responses.GameForListDto;
import com.gabo.videoClub.dto.responses.GameResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.entities.Game;
import com.gabo.videoClub.entities.Movie;
import com.gabo.videoClub.mappers.IGameMapper;
import com.gabo.videoClub.mappers.IMovieMapper;
import com.gabo.videoClub.repositories.IGameRepository;
import com.gabo.videoClub.repositories.IMovieRepository;
import com.gabo.videoClub.services.IGameService;
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
public class GameServiceImpl implements IGameService {
    private IGameRepository gameRepository;

    private IGameMapper gameMapper = Mappers.getMapper(IGameMapper.class);

    public GameServiceImpl(IGameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public ResponseEntity<EntityModel<ResponseInfo>> saveGame(GameRequestDto gameRequest) {
        Game game = gameMapper.gameRequestToGame(gameRequest);

        Integer id = gameRepository.save(game).getId();

        ResponseInfo response = new ResponseInfo("Game created successfully.", HttpStatus.CREATED.value());

        return ResponseEntity.status(HttpStatus.CREATED).body(EntityModel.of(response, this.getSelfLink(id), this.getCollectionLink()));
    }

    @Override
    public List<GameForListDto> getAllGames() {
        return null;
    }

    @Override
    public GameResponseDto getGameById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseInfo> deleteGame(Integer id) {
        return null;
    }

    @Override
    public Link getSelfLink(Integer id) {
        return linkTo(methodOn(ProductController.class).getGameById(id)).withRel("Show game:");
    }

    @Override
    public Link getCollectionLink() {
        return linkTo(methodOn(ProductController.class).getAllGames()).withRel("Show all games:");
    }

    @Override
    public Link getDeleteLink(Integer id) {
        return linkTo(methodOn(ProductController.class).deleteGameById(id)).withRel("Delete game:");
    }
}
