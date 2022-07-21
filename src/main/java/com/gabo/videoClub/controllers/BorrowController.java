package com.gabo.videoClub.controllers;

import com.gabo.videoClub.dto.requests.BorrowRequestDto;
import com.gabo.videoClub.dto.responses.BorrowForListDto;
import com.gabo.videoClub.dto.responses.BorrowResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.services.IBorrowService;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    private IBorrowService borrowService;

    public BorrowController(IBorrowService borrowService){
        this.borrowService = borrowService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<ResponseInfo>> createBorrow(@RequestBody BorrowRequestDto borrowRequestDto){
        return borrowService.createBorrow(borrowRequestDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EntityModel<BorrowResponseDto>> getBorrowById(@PathVariable Integer id) {
        return borrowService.getBorrowById(id);
    }

    @GetMapping
    public ResponseEntity<List<BorrowForListDto>> getAllBorrows(){
        return borrowService.getAllBorrows();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseInfo> deleteBorrowById(@PathVariable Integer id) {
        return null;
    }

}
