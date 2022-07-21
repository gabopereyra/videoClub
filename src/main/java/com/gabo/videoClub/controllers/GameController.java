package com.gabo.videoClub.controllers;

import com.gabo.videoClub.dto.requests.GameRequestDto;
import com.gabo.videoClub.dto.responses.GameForListDto;
import com.gabo.videoClub.dto.responses.GameResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.services.IGameService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {
    private IGameService gameService;

    public GameController(IGameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<ResponseInfo>> createGame(@Valid @RequestBody GameRequestDto game){
        return gameService.saveGame(game);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EntityModel<GameResponseDto>> getGameById(@PathVariable Integer id) {
        return gameService.getGameById(id);
    }

    @GetMapping
    public ResponseEntity<List<GameForListDto>> getAllGames(){
        return gameService.getAllGames();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseInfo> deleteGameById(@PathVariable Integer id) {
        return gameService.deleteGame(id);
    }
}
