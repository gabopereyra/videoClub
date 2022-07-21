package com.gabo.videoClub.mappers;

import com.gabo.videoClub.controllers.BorrowController;
import com.gabo.videoClub.dto.responses.BorrowForListDto;
import com.gabo.videoClub.dto.responses.BorrowResponseDto;
import com.gabo.videoClub.dto.responses.ClientForListDto;
import com.gabo.videoClub.dto.responses.ProductForListDto;
import com.gabo.videoClub.entities.Borrow;
import com.gabo.videoClub.entities.Client;
import com.gabo.videoClub.entities.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper
public interface IBorrowMapper {

    IClientMapper clientMapper = Mappers.getMapper(IClientMapper.class);

    IProductMapper productMapper = Mappers.getMapper(IProductMapper.class);

    @AfterMapping
    default void setClientDto(Borrow borrow, @MappingTarget BorrowResponseDto borrowResponseDto) {
        borrowResponseDto.setClient(clientMapper.clientToClientForListDto(borrow.getClient()));
    }
    @AfterMapping
    default void setProductsDto(Borrow borrow, @MappingTarget BorrowResponseDto borrowResponseDto) {
        List<ProductForListDto> products = borrow.getProducts()
                .stream()
                .map(productMapper::productToProductForList).collect(Collectors.toList());

        borrowResponseDto.setProducts(products);
    }
    BorrowResponseDto borrowToResponseDto(Borrow borrow);

    @AfterMapping
    default void setName(Borrow borrow, @MappingTarget BorrowForListDto borrowForListDto) {
        borrowForListDto.setClientName(borrow.getClient().getNombre());
    }
    @AfterMapping
    default void setProductQuantity(Borrow borrow, @MappingTarget BorrowForListDto borrowForListDto) {
        borrowForListDto.setTotalProducts(borrow.getProducts().size());
    }
    @AfterMapping
    default void setLink(Borrow borrow, @MappingTarget BorrowForListDto borrowForListDto) {
        Integer id = borrow.getId();
        borrowForListDto.setLink(linkTo(methodOn(BorrowController.class).getBorrowById(id)).toString());
    }
    BorrowForListDto borrowToBorrowForListDto(Borrow borrow);

    List<BorrowForListDto> borrowListToResponseDto(List<Borrow> borrow);
}
