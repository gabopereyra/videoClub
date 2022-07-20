package com.gabo.videoClub.mappers;

import com.gabo.videoClub.dto.requests.GameRequestDto;
import com.gabo.videoClub.dto.responses.GameResponseDto;
import com.gabo.videoClub.entities.Game;
import org.mapstruct.Mapper;

@Mapper
public interface IGameMapper {
    Game gameRequestToGame(GameRequestDto gameRequest);

    GameResponseDto gameToGameResponseDto(Game game);


}
