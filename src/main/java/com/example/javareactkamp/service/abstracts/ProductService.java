package com.example.javareactkamp.service.abstracts;

import com.example.javareactkamp.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
  List<Product> getAll() ;

  void createProduct(Product product);
  void  updateProduct(Product product);
  void deleteProduct(int id);



}
