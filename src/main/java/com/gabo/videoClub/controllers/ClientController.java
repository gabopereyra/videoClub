package com.gabo.videoClub.controllers;


import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.services.IClientService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private IClientService clientService;

    public ClientController(IClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<ResponseInfo>> createClient(@Valid @RequestBody ClientRequestDto client){
        Integer id = clientService.save(client).getId();

        ResponseInfo response = new ResponseInfo("Client created successfully.", HttpStatus.CREATED.value());

        return ResponseEntity.ok()
                .body(EntityModel.of(response, clientService.getSelfLink(id), clientService.getCollectionLink()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getClientById(@PathVariable Integer id) {
        return null;
    }
    @GetMapping
    public ResponseEntity getAllClients(){
        return null;
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteClientById(@PathVariable Integer id) {
        return null;
    }
}
