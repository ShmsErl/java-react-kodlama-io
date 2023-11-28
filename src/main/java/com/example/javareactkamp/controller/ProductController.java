package com.example.javareactkamp.controller;

import com.example.javareactkamp.dto.productDto.AddProductRequest;
import com.example.javareactkamp.dto.productDto.GetAllProductResponse;
import com.example.javareactkamp.dto.productDto.GetByProductResponse;
import com.example.javareactkamp.model.Product;
import com.example.javareactkamp.repository.ProductRepository;
import com.example.javareactkamp.service.abstracts.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.catalina.connector.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/getall")
    public ResponseEntity<List<GetAllProductResponse>> getProducts() {

        return new ResponseEntity<>(this.productService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/getbyname{productName}")
    public ResponseEntity<GetByProductResponse> getByProduct(@RequestParam String productName){


        return  new ResponseEntity<>(this.productService.getByProduct(productName), HttpStatus.OK);
    }
    @GetMapping("/getbyid{id}")
    public ResponseEntity<GetByProductResponse> getByProduct(@RequestParam int id){


        return  new ResponseEntity<>(this.productService.getByProduct(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createProduct(@Valid @RequestBody AddProductRequest request) {


        return new ResponseEntity<String>(this.productService.createProduct(request), HttpStatus.CREATED);

    }
}
