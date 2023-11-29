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
    @GetMapping("/getbyname")
    public ResponseEntity<GetByProductResponse> getByProduct( String productName){


        return  new ResponseEntity<>(this.productService.getByProduct(productName), HttpStatus.OK);
    }
    @GetMapping("/getbyid{id}")
    public ResponseEntity<GetByProductResponse> getByProduct(@PathVariable int id){


        return  new ResponseEntity<>(this.productService.getByProduct(id), HttpStatus.OK);
    }
        @GetMapping("/get")
    public ResponseEntity<GetByProductResponse> getByNameAndCategoryId(  @RequestParam String productName, @RequestParam Integer id) {


        return new ResponseEntity<>(this.productService.getByNameAndCategoryId(productName, id),HttpStatus.OK);

    }

    @GetMapping("/g")
    public ResponseEntity<List<GetByProductResponse>> getByNameOrCategoryId(  @RequestParam String productName, @RequestParam Integer id) {


        return new ResponseEntity<>(this.productService.getByNameOrCategoryId(productName, id),HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<String> createProduct(@Valid @RequestBody AddProductRequest request) {


        return new ResponseEntity<String>(this.productService.createProduct(request), HttpStatus.CREATED);

    }
    @GetMapping("/nameIn")
    public ResponseEntity< List<GetByProductResponse>> getByNameIn(@RequestParam List<String> productNames){


        return new ResponseEntity<>(this.productService.getByNameIn(productNames), HttpStatus.OK);
    }
    @GetMapping("/namecontains")
    public ResponseEntity< List<GetByProductResponse>> getByNameContains(@RequestParam String productName){


        return new ResponseEntity<>(this.productService.getByNameContains(productName), HttpStatus.OK);
    }
}
