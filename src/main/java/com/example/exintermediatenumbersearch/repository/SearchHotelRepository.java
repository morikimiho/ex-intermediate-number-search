package com.example.exintermediatenumbersearch.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.exintermediatenumbersearch.model.Hotel;

@Repository
public class SearchHotelRepository {
    private static final String FIND_ALL = """
            SELECT
                id,
                area_name,
                hotel_name,
                address,
                nearest_station,
                price,
                parking
            FROM
                hotels;
            """;

    private static final String FIND_BY_PRICE = """
            SELECT
                id,
                area_name,
                hotel_name,
                address,
                nearest_station,
                price,
                parking
            FROM
                hotels
            WHERE
                price <= :price;
            """;

    private static final RowMapper<Hotel> RESULT_ROW_MAPPER = new BeanPropertyRowMapper<>(Hotel.class);

    @Autowired
    private NamedParameterJdbcTemplate template;

    /** ホテルの全件取得 */
    public List<Hotel> findAll() {
        List<Hotel> hotels = template.query(FIND_ALL, RESULT_ROW_MAPPER);

        return hotels;
        
    }

    /**
     * 条件に合ったホテルの取得
     * @param price
     * @return 一致するホテルの情報
     */

    public List<Hotel> findByPrice(Integer price) {
        SqlParameterSource params = new MapSqlParameterSource().addValue("price", price);
        List<Hotel> filterHotels = template.query(FIND_BY_PRICE, params, RESULT_ROW_MAPPER);

        return filterHotels;
    }
}
