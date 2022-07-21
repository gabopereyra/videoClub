package com.gabo.videoClub.services;

import com.gabo.videoClub.dto.requests.BorrowRequestDto;
import com.gabo.videoClub.dto.responses.BorrowResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface IBorrowService extends IHateoas <Integer>{
    public ResponseEntity<EntityModel<ResponseInfo>> createBorrow(BorrowRequestDto borrowRequestDto);
    public ResponseEntity<EntityModel<BorrowResponseDto>> getBorrowById(Integer id);
}
