package com.example.javareactkamp.service.abstracts;

import com.example.javareactkamp.dto.productDto.AddProductRequest;
import com.example.javareactkamp.dto.productDto.GetAllProductResponse;
import com.example.javareactkamp.dto.productDto.GetByProductResponse;
import com.example.javareactkamp.dto.productDto.UpdateProductRequest;
import com.example.javareactkamp.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    List<GetAllProductResponse> getAll();

    GetByProductResponse getByProduct(String product);

    GetByProductResponse getByProduct(int id);

    void createProduct(AddProductRequest request);

    void updateProduct(UpdateProductRequest request);

    void deleteProduct(int id);


}
