package com.gabo.videoClub.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/docs")
@ApiIgnore
public class SwaggerController {

    @GetMapping
    public ModelAndView swaggerPage(HttpServletResponse response) {
        return new ModelAndView("redirect:/swagger-ui.html");
    }
}