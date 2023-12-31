package com.example.javareactkamp.service.abstracts;

import com.example.javareactkamp.dto.ProductWithCategoryDto;
import com.example.javareactkamp.dto.productDto.AddProductRequest;
import com.example.javareactkamp.dto.productDto.GetAllProductResponse;
import com.example.javareactkamp.dto.productDto.GetByProductResponse;
import com.example.javareactkamp.dto.productDto.UpdateProductRequest;
import com.example.javareactkamp.model.Product;
import org.hibernate.query.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    List<GetAllProductResponse> getAll(int pageNo , int pageSize);
    List<GetAllProductResponse> getAll(int pageNo , int pageSize, String properties);

    GetByProductResponse getByProduct(String productName);

    GetByProductResponse getByProduct(int id);

    String createProduct(AddProductRequest request);

    String updateProduct(UpdateProductRequest request);

    String deleteProduct(int id) throws Exception;

    GetByProductResponse getByNameAndCategoryId(String productName, Integer id);

    List<GetByProductResponse> getByNameOrCategoryId(String productName, Integer id);

    List<GetByProductResponse> getByNameIn(List<String> productNames);

    List<GetByProductResponse> getByNameContains(String productName);

    List<GetByProductResponse> getByNameStartsWith(String productName);

    List<ProductWithCategoryDto> getProductWithCategoryDetails();


}
