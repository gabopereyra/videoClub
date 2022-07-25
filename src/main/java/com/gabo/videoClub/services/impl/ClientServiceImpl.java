package com.gabo.videoClub.services.impl;

import com.gabo.videoClub.controllers.ClientController;
import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientForListDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.entities.Borrow;
import com.gabo.videoClub.entities.Client;
import com.gabo.videoClub.mappers.IClientMapper;
import com.gabo.videoClub.repositories.IClientRepository;
import com.gabo.videoClub.services.IBorrowService;
import com.gabo.videoClub.services.IClientService;
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
public class ClientServiceImpl implements IClientService {
    private IClientRepository clientRepository;

    private IBorrowService borrowService;

    public ClientServiceImpl(IClientRepository clientRepository, IBorrowService borrowService) {
        this.clientRepository = clientRepository;
        this.borrowService = borrowService;
    }

    IClientMapper clientMapper = Mappers.getMapper(IClientMapper.class);

    @Override
    public ResponseEntity<EntityModel<ResponseInfo>> save(ClientRequestDto clientDto) {
        Client client = clientMapper.requestToClient(clientDto);

        Integer id = clientRepository.save(client).getId();

        ResponseInfo response = new ResponseInfo("CLient created successfully.", HttpStatus.CREATED.value());

        return ResponseEntity.status(HttpStatus.CREATED).body(EntityModel.of(response, this.getSelfLink(id), this.getCollectionLink()));
     }

    @Override
    public List<ClientForListDto> getAllClients() {
        List<Client> clients = clientRepository.findAll();

        return clientMapper.clientToListDto(clients);
    }

    @Override
    public ResponseEntity<EntityModel<ClientResponseDto>> getClientById(Integer id) {
        Client client = clientRepository.findById(id).get();

        ClientResponseDto clientResponse = clientMapper.clientToResponseDto(client);

        return ResponseEntity.ok().body(EntityModel.of(clientResponse, this.getCollectionLink()));
    }

    @Override
    public ResponseEntity<ResponseInfo> deleteClient(Integer id) {
        deleteRelatedBorrows(id);
        clientRepository.deleteById(id);
        ResponseInfo response = new ResponseInfo("Client deleted successfully.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public Link getSelfLink(Integer id) {
        return linkTo(methodOn(ClientController.class).getClientById(id)).withRel("Show client:");
    }

    @Override
    public Link getCollectionLink() {
        return linkTo(methodOn(ClientController.class).getAllClients()).withRel("Show all clients:");
    }

    @Override
    public Link getDeleteLink(Integer id) {
        return linkTo(methodOn(ClientController.class).deleteClientById(id)).withRel("Delete client:");
    }

    private void deleteRelatedBorrows(Integer id) {
        borrowService.deleteRelatedBorrow(id);
    }
}
