package com.example.javareactkamp.service.concretes;

import com.example.javareactkamp.dto.productDto.AddProductRequest;
import com.example.javareactkamp.dto.productDto.GetAllProductResponse;
import com.example.javareactkamp.dto.productDto.GetByProductResponse;
import com.example.javareactkamp.dto.productDto.UpdateProductRequest;
import com.example.javareactkamp.service.abstracts.ProductService;

import java.util.List;

public class ProductManager implements ProductService {
    @Override
    public List<GetAllProductResponse> getAll() {
        return null;
    }

    @Override
    public GetByProductResponse getByProduct(String product) {
        return null;
    }

    @Override
    public GetByProductResponse getByProduct(int id) {
        return null;
    }

    @Override
    public void createProduct(AddProductRequest request) {

    }

    @Override
    public void updateProduct(UpdateProductRequest request) {

    }

    @Override
    public void deleteProduct(int id) {

    }
}
