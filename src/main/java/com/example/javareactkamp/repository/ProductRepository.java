package com.example.javareactkamp.repository;

import com.example.javareactkamp.dto.ProductWithCategoryDto;
import com.example.javareactkamp.model.Product;
import jakarta.persistence.criteria.From;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String productName);

    boolean existsByName(String productName);

    Optional<Product> getByNameAndCategory_Id(String productName, Integer id);

    Optional<List<Product>> getByNameOrCategory_Id(String productName, Integer id);

    List<Product> getByNameIn(List<String> productNames);

    List<Product> getByNameContains(String productName);

    List<Product> getByNameStartsWith(String productName);

    @Query(value = "Select new com.example.javareactkamp.dto.ProductWithCategoryDto" +
            " (p.id,p.name,c.name) from  Category c Inner Join c.products p ")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();




}
