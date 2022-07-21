package com.gabo.videoClub.controllers;


import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientForListDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.services.IClientService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    private IClientService clientService;

    public ClientController(IClientService clientService){
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<ResponseInfo>> createClient(@Valid @RequestBody ClientRequestDto client){
        return clientService.save(client);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EntityModel<ClientResponseDto>> getClientById(@PathVariable Integer id) {
        return clientService.getClientById(id);
    }

    @GetMapping
    public ResponseEntity<List<ClientForListDto>> getAllClients(){
        return ResponseEntity.ok().body(clientService.getAllClients());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseInfo> deleteClientById(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }
}
