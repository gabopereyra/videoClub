package com.gabo.videoClub.mappers;

import com.gabo.videoClub.controllers.ClientController;
import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientForListDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;
import com.gabo.videoClub.entities.Client;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper
public interface IClientMapper {
    Client requestToClient(ClientRequestDto client);

    ClientResponseDto clientToResponseDto(Client client);

    @BeforeMapping
    default void setTypeCar(Client client, @MappingTarget ClientForListDto ClientForListDto) {
        Integer id = client.getId();
        ClientForListDto.setLink(linkTo(methodOn(ClientController.class).getClientById(id)).toString());
    }
    ClientForListDto clientToClientForListDto(Client client);

    List<ClientForListDto> clientToListDto(List<Client> client);

}
