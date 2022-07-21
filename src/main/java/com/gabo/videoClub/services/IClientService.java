package com.gabo.videoClub.services;

import com.gabo.videoClub.dto.requests.ClientRequestDto;
import com.gabo.videoClub.dto.responses.ClientForListDto;
import com.gabo.videoClub.dto.responses.ClientResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientService extends IHateoas <Integer> {
    public ResponseEntity<EntityModel<ResponseInfo>> save(ClientRequestDto clientResponse);
    public List<ClientForListDto> getAllClients();
    public ResponseEntity<EntityModel<ClientResponseDto>> getClientById(Integer id);
    public ResponseEntity<ResponseInfo> deleteClient(Integer id);
}
