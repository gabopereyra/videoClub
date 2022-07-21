package com.gabo.videoClub.mappers;

import com.gabo.videoClub.dto.responses.BorrowResponseDto;
import com.gabo.videoClub.dto.responses.ProductForListDto;
import com.gabo.videoClub.entities.Borrow;
import com.gabo.videoClub.entities.Product;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

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
}
