package com.gabo.videoClub.services.impl;

import com.gabo.videoClub.controllers.ClientController;
import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;
import com.gabo.videoClub.entities.Client;
import com.gabo.videoClub.mappers.IClientMapper;
import com.gabo.videoClub.repositories.IClientRepository;
import com.gabo.videoClub.services.IClientService;
import org.mapstruct.factory.Mappers;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ClientServiceImpl implements IClientService {
    private IClientRepository clientRepository;

    public ClientServiceImpl(IClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    IClientMapper clientMapper = Mappers.getMapper(IClientMapper.class);

    @Override
    public ClientResponseDto save(ClientRequestDto clientDto) {
        Client saved = clientRepository.save(clientMapper.requestToClient(clientDto));

        return clientMapper.clientToResponseDto(saved);
    }

    @Override
    public List<ClientResponseDto> getAllClients() {
        return null;
    }

    @Override
    public ClientResponseDto getClientById(Integer id) {
        Client client = clientRepository.findById(id).get();

        return clientMapper.clientToResponseDto(client);
    }

    @Override
    public void deleteClient(Integer id) {

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
}
