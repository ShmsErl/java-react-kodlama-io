    package com.example.javareactkamp.dto.productDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
    private int id;
    private String name;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitInStock;
    private int unitsOnOrder;
    private int reorderLevel;
    private int discontinued;
    private String categoryName;
}
