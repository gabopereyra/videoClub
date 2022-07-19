package com.gabo.videoClub.controllers;

import com.gabo.videoClub.services.IGameService;
import com.gabo.videoClub.services.IMovieService;
import com.gabo.videoClub.services.IProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private IProductService productService;
    private IGameService gameService;
    private IMovieService movieService;

    public ProductController(IProductService productService, IGameService gameService, IMovieService movieService){
        this.productService = productService;
        this.gameService = gameService;
        this.movieService = movieService;
    }


}
