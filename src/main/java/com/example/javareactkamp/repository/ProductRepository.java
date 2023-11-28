package com.example.javareactkamp.repository;

import com.example.javareactkamp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
