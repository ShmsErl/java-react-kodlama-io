package com.example.javareactkamp.dto.productDto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
    private int category;
    private String name;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitInStock;
    private int unitsOnOrder;
    private int reorderLevel;
    private int discontinued;
}
