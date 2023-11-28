package com.example.javareactkamp.service.rules;

import com.example.javareactkamp.exception.ProductAlreadyExistsException;
import com.example.javareactkamp.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.experimental.UtilityClass;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ProductBusinessRulesManager implements ProductBusinessRulesService {

    private final ProductRepository repository;

    @Override
    public void IfCheckProductName(String productName) {
        if(this.repository.findProductsBy(productName)){

          throw  new ProductAlreadyExistsException("Product already exists");
        }

    }


}
