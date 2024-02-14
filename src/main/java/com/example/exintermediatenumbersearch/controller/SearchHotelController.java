package com.example.exintermediatenumbersearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediatenumbersearch.service.SearchHotelService;

@Controller
@RequestMapping({"", "/"})
public class SearchHotelController {
    @Autowired SearchHotelService searchHotelService;

    @GetMapping("/search")
    public String index() {
        return "search/index";
    }
}
