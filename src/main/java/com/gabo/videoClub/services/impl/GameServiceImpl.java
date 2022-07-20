package com.gabo.videoClub.services.impl;

import com.gabo.videoClub.controllers.GameController;
import com.gabo.videoClub.dto.requests.GameRequestDto;
import com.gabo.videoClub.dto.responses.*;
import com.gabo.videoClub.entities.Game;
import com.gabo.videoClub.entities.Movie;
import com.gabo.videoClub.mappers.IGameMapper;
import com.gabo.videoClub.repositories.IGameRepository;
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
    public ResponseEntity<List<GameForListDto>> getAllGames() {

        List<GameForListDto> games = gameMapper.gameToListDto(gameRepository.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(games);
    }

    @Override
    public ResponseEntity<EntityModel<GameResponseDto>> getGameById(Integer id) {
        Game game = gameRepository.findById(id).get();
        GameResponseDto gameResponseDto = gameMapper.gameToGameResponseDto(game);

        return ResponseEntity.status(HttpStatus.OK).body(EntityModel.of(gameResponseDto, this.getCollectionLink()));
    }

    @Override
    public ResponseEntity<ResponseInfo> deleteGame(Integer id) {
        gameRepository.deleteById(id);
        ResponseInfo response = new ResponseInfo("Game deleted successfully.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @Override
    public Link getSelfLink(Integer id) {
        return linkTo(methodOn(GameController.class).getGameById(id)).withRel("Show game:");
    }

    @Override
    public Link getCollectionLink() {
        return linkTo(methodOn(GameController.class).getAllGames()).withRel("Show all games:");
    }

    @Override
    public Link getDeleteLink(Integer id) {
        return linkTo(methodOn(GameController.class).deleteGameById(id)).withRel("Delete game:");
    }
}
