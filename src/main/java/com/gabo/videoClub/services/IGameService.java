package com.gabo.videoClub.services;

import com.gabo.videoClub.dto.requests.GameRequestDto;
import com.gabo.videoClub.dto.responses.GameForListDto;
import com.gabo.videoClub.dto.responses.GameResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IGameService extends IHateoas <Integer>{
        public ResponseEntity<EntityModel<ResponseInfo>> saveGame(GameRequestDto gameRequestDto);
        public List<GameForListDto> getAllGames();
        public GameResponseDto getGameById(Integer id);
        public ResponseEntity<ResponseInfo> deleteGame(Integer id);
}
