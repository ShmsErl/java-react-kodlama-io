package com.example.javareactkamp.controller;

import com.example.javareactkamp.model.Product;
import com.example.javareactkamp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final  ProductRepository productRepository;
    @GetMapping("/getall")
    public List<Product> getProducts() {

        return this.productRepository.findAll();
    }
}
