package com.example.javareactkamp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductWithCategoryDto {
    private int id;
    private String productName;
    private String categoryName;

    public ProductWithCategoryDto(int id, String productName, String categoryName) {
        this.id = id;
        this.productName = productName;
        this.categoryName = categoryName;
    }

}
