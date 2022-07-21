package com.gabo.videoClub.mappers;

import com.gabo.videoClub.controllers.GameController;
import com.gabo.videoClub.dto.requests.GameRequestDto;
import com.gabo.videoClub.dto.responses.GameForListDto;
import com.gabo.videoClub.dto.responses.GameResponseDto;
import com.gabo.videoClub.entities.Game;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper
public interface IGameMapper {
    Game gameRequestToGame(GameRequestDto gameRequest);

    GameResponseDto gameToGameResponseDto(Game game);

     @BeforeMapping
        default void setLink(Game game, @MappingTarget GameForListDto gameForListDto) {
            Integer id = game.getId();
            gameForListDto.setLink(linkTo(methodOn(GameController.class).getGameById(id)).toString());
        }
        GameForListDto gameToGameForListDto(Game game);

        List<GameForListDto> gameToListDto(List<Game> game);
}
