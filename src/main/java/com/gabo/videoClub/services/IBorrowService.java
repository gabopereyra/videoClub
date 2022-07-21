package com.gabo.videoClub.services;

import com.gabo.videoClub.dto.requests.BorrowRequestDto;
import com.gabo.videoClub.dto.responses.BorrowForListDto;
import com.gabo.videoClub.dto.responses.BorrowResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBorrowService extends IHateoas <Integer>{
    public ResponseEntity<EntityModel<ResponseInfo>> createBorrow(BorrowRequestDto borrowRequestDto);
    public ResponseEntity<EntityModel<BorrowResponseDto>> getBorrowById(Integer id);
    public ResponseEntity<List<BorrowForListDto>> getAllBorrows();
    public ResponseEntity<ResponseInfo> writeOffBorrow(Integer id);
}
