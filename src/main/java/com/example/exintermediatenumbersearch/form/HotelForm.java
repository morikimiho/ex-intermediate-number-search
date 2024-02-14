package com.example.exintermediatenumbersearch.form;

import jakarta.validation.constraints.Pattern;

public class HotelForm {
    /** 価格 */
    @Pattern(regexp = "[0-9]+", message = "半角数字で入力してください")
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "HotelForm [price=" + price + "]";
    }
}
