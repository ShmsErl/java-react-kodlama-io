package com.example.javareactkamp.repository;

import com.example.javareactkamp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> getProductsBy(String productName);
    boolean findProductsBy(String productName);
    boolean findProductsBy(int id);

}
