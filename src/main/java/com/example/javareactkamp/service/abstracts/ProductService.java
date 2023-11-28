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

    GetByProductResponse getByProduct(String productName);

    GetByProductResponse getByProduct(int id);

    String createProduct(AddProductRequest request);

    String  updateProduct(UpdateProductRequest request);

    String deleteProduct(int id) throws Exception;


}
