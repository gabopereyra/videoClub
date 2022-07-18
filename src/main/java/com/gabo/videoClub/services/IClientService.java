package com.gabo.videoClub.services;

import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientForListDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;

import java.util.List;

public interface IClientService extends IHateoas <Integer> {
    public ClientResponseDto save(ClientRequestDto clientResponse);
    public List<ClientForListDto> getAllClients();
    public ClientResponseDto getClientById(Integer id);
    public void deleteClient(Integer id);
}
