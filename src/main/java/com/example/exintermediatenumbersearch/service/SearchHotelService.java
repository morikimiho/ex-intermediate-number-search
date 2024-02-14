package com.example.exintermediatenumbersearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exintermediatenumbersearch.model.Hotel;
import com.example.exintermediatenumbersearch.repository.SearchHotelRepository;

@Service
@Transactional
public class SearchHotelService {
    @Autowired
    private SearchHotelRepository searchHotelRepository;

    /** レポジトリの全件取得メソッドを呼ぶ */
    public List<Hotel> findAll() {
        List<Hotel> hotels = searchHotelRepository.findAll();

        return hotels;
    }

    /** レポジトリの条件を絞ったデータ取得メソッドを呼ぶ */
    public List<Hotel> filterHotels(Integer price) {
        List<Hotel> filterHotels = searchHotelRepository.findByPrice(price);

        return filterHotels;
    }
}
