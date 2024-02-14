package com.example.exintermediatenumbersearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.exintermediatenumbersearch.form.HotelForm;
import com.example.exintermediatenumbersearch.model.Hotel;
import com.example.exintermediatenumbersearch.service.SearchHotelService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({"", "/"})
public class SearchHotelController {
    @Autowired SearchHotelService searchHotelService;

    @Autowired
    private HttpSession session;

    @GetMapping("/search")
    public String index() {
        return "search/index";
    }

    @PostMapping("/search-hotel")
    public String searchHotel(HotelForm form,Model model) { 
            if(form.getPrice() == null) {
                List<Hotel> hotels = searchHotelService.findAll();
                session.setAttribute("hotels", hotels);
            } else {
                List<Hotel> filterHotels = searchHotelService.filterHotels(form.getPrice());
                session.removeAttribute("nullError");
                if(filterHotels.size() == 0) {
                    System.out.println("0です");
                    session.setAttribute("nullError", "条件に合うデータが存在しません");
                }
                session.setAttribute("hotels", filterHotels);
            }
            return "redirect:/search";
    }
}
