package com.gabo.videoClub.mappers;

import com.gabo.videoClub.controllers.GameController;
import com.gabo.videoClub.controllers.MovieController;
import com.gabo.videoClub.dto.responses.ProductForListDto;
import com.gabo.videoClub.entities.Game;
import com.gabo.videoClub.entities.Movie;
import com.gabo.videoClub.entities.Product;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Mapper
public interface IProductMapper {

    @BeforeMapping
    default void setLink(Product product, @MappingTarget ProductForListDto productForListDto) {
        Integer id = product.getId();
        if(product instanceof Movie){
            productForListDto.setLink(linkTo(methodOn(MovieController.class).getMovieById(id)).toString());
            productForListDto.setClassType("Movie");
        }
        if(product instanceof Game){
            productForListDto.setLink(linkTo(methodOn(GameController.class).getGameById(id)).toString());
            productForListDto.setClassType("Game");
        }
    }
    ProductForListDto productToProductForList(Product product);
}
