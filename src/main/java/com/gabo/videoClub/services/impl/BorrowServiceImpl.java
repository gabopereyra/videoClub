package com.gabo.videoClub.services.impl;

import com.gabo.videoClub.controllers.BorrowController;
import com.gabo.videoClub.dto.requests.BorrowRequestDto;
import com.gabo.videoClub.dto.responses.BorrowForListDto;
import com.gabo.videoClub.dto.responses.BorrowResponseDto;
import com.gabo.videoClub.dto.responses.ResponseInfo;
import com.gabo.videoClub.entities.Borrow;
import com.gabo.videoClub.entities.Product;
import com.gabo.videoClub.mappers.IBorrowMapper;
import com.gabo.videoClub.repositories.IBorrowRepository;
import com.gabo.videoClub.repositories.IClientRepository;
import com.gabo.videoClub.repositories.IProductRepository;
import com.gabo.videoClub.services.IBorrowService;
import org.mapstruct.factory.Mappers;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class BorrowServiceImpl implements IBorrowService {
    private IBorrowRepository borrowRepository;

    private IProductRepository productRepository;

    private IClientRepository clientRepository;

    public BorrowServiceImpl(IBorrowRepository borrowRepository, IProductRepository productRepository, IClientRepository clientRepository) {
        this.borrowRepository = borrowRepository;
        this.productRepository = productRepository;
        this.clientRepository = clientRepository;
    }

    private IBorrowMapper borrowMapper = Mappers.getMapper(IBorrowMapper.class);

    @Override
    public ResponseEntity<EntityModel<ResponseInfo>> createBorrow(BorrowRequestDto borrowRequestDto) {
        Borrow borrow = new Borrow();
        borrow.setClient(clientRepository.findById(borrowRequestDto.getId_client()).get());
        borrow.setProducts(getListOfProducts(borrowRequestDto.getProducts()));
        borrow.setFinalizationDate(borrow.getInitialDate().plusDays(7L));

        Integer id = borrowRepository.save(borrow).getId();

        ResponseInfo response = new ResponseInfo("Borrow created successfully. Date of finalization: "+borrow.getFinalizationDate(), HttpStatus.CREATED.value());

        return ResponseEntity.status(HttpStatus.CREATED).body(EntityModel.of(response, this.getSelfLink(id), this.getCollectionLink()));
    }

    @Override
    public ResponseEntity<EntityModel<BorrowResponseDto>> getBorrowById(Integer id) {
        Borrow borrow = borrowRepository.findById(id).get();

        BorrowResponseDto borrowResponseDto = borrowMapper.borrowToResponseDto(borrow);

        return ResponseEntity.status(HttpStatus.OK).body(EntityModel.of(borrowResponseDto, this.getCollectionLink()));
    }

    @Override
    public ResponseEntity<List<BorrowForListDto>> getAllBorrows() {
        List<BorrowForListDto> allBorrows = borrowMapper.borrowListToResponseDto(borrowRepository.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(allBorrows);
    }

    @Override
    public ResponseEntity<ResponseInfo> writeOffBorrow(Integer id) {
        borrowRepository.deleteById(id);
        ResponseInfo response = new ResponseInfo("Borrow finished successfully.", HttpStatus.OK.value());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    private List<Product> getListOfProducts(List<Integer> idProductsNumbers){
        List<Product> products = new ArrayList<>();

        for (Integer idProduct: idProductsNumbers) {
            products.add(productRepository.findById(idProduct).get());
        }

        return products;
    }


    @Override
    public Link getSelfLink(Integer id) {
        return linkTo(methodOn(BorrowController.class).getBorrowById(id)).withRel("Show borrow:");
    }

    @Override
    public Link getCollectionLink() {
        return linkTo(methodOn(BorrowController.class).getAllBorrows()).withRel("Show all borrows:");
    }

    @Override
    public Link getDeleteLink(Integer id) {
        return linkTo(methodOn(BorrowController.class).writeOffBorrow(id)).withRel("Write off borrow:");
    }
}
