package com.gabo.videoClub.mappers;

import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;
import com.gabo.videoClub.entities.Client;
import org.mapstruct.Mapper;

@Mapper
public interface IClientMapper {
    Client requestToClient(ClientRequestDto client);

    ClientResponseDto clientToResponseDto(Client client);
}
