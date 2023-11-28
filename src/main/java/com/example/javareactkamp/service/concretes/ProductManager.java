package com.example.javareactkamp.service.concretes;

import com.example.javareactkamp.dto.productDto.AddProductRequest;
import com.example.javareactkamp.dto.productDto.GetAllProductResponse;
import com.example.javareactkamp.dto.productDto.GetByProductResponse;
import com.example.javareactkamp.dto.productDto.UpdateProductRequest;
import com.example.javareactkamp.mapper.MapperService;
import com.example.javareactkamp.model.Product;
import com.example.javareactkamp.repository.ProductRepository;
import com.example.javareactkamp.service.abstracts.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final MapperService mapperService;


    @Override
    public List<GetAllProductResponse> getAll() {

        List<Product> products = this.productRepository.findAll();
        List<GetAllProductResponse> responses = new ArrayList<>();
        for (Product product : products) {

            GetAllProductResponse response = this.mapperService
                    .forResponse()
                    .map(product,GetAllProductResponse.class);

            responses.add(response);
        }


        return responses;
    }

    @Override
    public GetByProductResponse getByProduct(String productName) {
        Product product = this.productRepository.getProductsBy(productName).orElseThrow();

        return
                this.mapperService.forResponse().map(product,GetByProductResponse.class);
    }

    @Override
    public GetByProductResponse getByProduct(int id) {
        Product product = this.productRepository.findById(id).orElseThrow();

        return
                this.mapperService.forResponse().map(product,GetByProductResponse.class);

    }

    @Override
    public void createProduct(AddProductRequest request) {
        Product product = this.mapperService.forRequest().map(request,Product.class);

        this.productRepository.save(product);

    }

    @Override
    public void updateProduct(UpdateProductRequest request) {

        Product product = this.mapperService.forRequest().map(request,Product.class);

        this.productRepository.save(product);


    }

    @Override
    public void deleteProduct(int id) throws Exception {
        this.productRepository.findById(id).orElseThrow(()-> new Exception("Could not find product"));

        this.productRepository.deleteById(id);

    }
}