package com.gabo.videoClub.controllers;


import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientForListDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.services.IClientService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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
        
        return ResponseEntity.status(HttpStatus.CREATED).body(EntityModel.of(response, clientService.getSelfLink(id), clientService.getCollectionLink()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EntityModel<ClientResponseDto>> getClientById(@PathVariable Integer id) {
        ClientResponseDto clientResponse = clientService.getClientById(id);
        return ResponseEntity.ok().body(EntityModel.of(clientResponse, clientService.getCollectionLink()));
    }
    @GetMapping
    public ResponseEntity<List<ClientForListDto>> getAllClients(){
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteClientById(@PathVariable Integer id) {
        return null;
    }
}
