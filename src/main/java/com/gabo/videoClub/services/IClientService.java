package com.gabo.videoClub.services;

import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;

import java.util.List;

public interface IClientService extends IHateoas <Long> {
    public ClientResponseDto save(ClientRequestDto clientResponse);
    public List<ClientResponseDto> getAllClients();
    public ClientResponseDto getClientById(Long id);
    public void deleteClient(Long id);
}
