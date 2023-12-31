package com.example.javareactkamp.service.concretes;

import com.example.javareactkamp.dto.ProductWithCategoryDto;
import com.example.javareactkamp.dto.productDto.AddProductRequest;
import com.example.javareactkamp.dto.productDto.GetAllProductResponse;
import com.example.javareactkamp.dto.productDto.GetByProductResponse;
import com.example.javareactkamp.dto.productDto.UpdateProductRequest;
import com.example.javareactkamp.exception.ProductNotFoundException;
import com.example.javareactkamp.mapper.MapperService;
import com.example.javareactkamp.model.Product;
import com.example.javareactkamp.repository.ProductRepository;
import com.example.javareactkamp.service.abstracts.ProductService;
import com.example.javareactkamp.service.rules.ProductBusinessRulesService;
import lombok.AllArgsConstructor;
import org.modelmapper.internal.bytebuddy.TypeCache;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {

    private final ProductRepository productRepository;
    private final MapperService mapperService;
    private final ProductBusinessRulesService businessRulesService;


    @Override
    public List<GetAllProductResponse> getAll() {

        List<Product> products = this.productRepository.findAll();
        List<GetAllProductResponse> responses = new ArrayList<>();
        for (Product product : products) {

            GetAllProductResponse response = this.mapperService
                    .forResponse()
                    .map(product, GetAllProductResponse.class);

            responses.add(response);
        }


        return responses;
    }

    @Override
    public List<GetAllProductResponse> getAll(int pageNo, int pageSize) {
     Pageable pageable  =  PageRequest.of(pageNo-1, pageSize, Sort.by( Sort.Direction.ASC,"unitPrice"));

        List<Product> products = this.productRepository.findAll(pageable).getContent();
        List<GetAllProductResponse> responses = new ArrayList<>();
        for (Product product : products) {

            GetAllProductResponse response = this.mapperService
                    .forResponse()
                    .map(product, GetAllProductResponse.class);

            responses.add(response);
        }
        return responses;
    }
    @Override
    public List<GetAllProductResponse> getAll(int pageNo , int pageSize, String properties){

        Pageable pageable  =  PageRequest.of(pageNo-1, pageSize,Sort.by(Sort.Direction.ASC,properties));

        List<Product> products = this.productRepository.findAll(pageable).getContent();
        List<GetAllProductResponse> responses = new ArrayList<>();
        for (Product product : products) {

            GetAllProductResponse response = this.mapperService
                    .forResponse()
                    .map(product, GetAllProductResponse.class);

            responses.add(response);
        }
        return responses;

    }

    @Override
    public GetByProductResponse getByProduct(String productName) {
        Product product = this.productRepository.findByName(productName).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        return
                this.mapperService.forResponse().map(product, GetByProductResponse.class);
    }

    @Override
    public GetByProductResponse getByProduct(int id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        return
                this.mapperService.forResponse().map(product, GetByProductResponse.class);

    }

    @Override
    public String createProduct(AddProductRequest request) {
        this.businessRulesService.IfCheckProductName(request.getName());
        Product product = this.mapperService.forRequest().map(request, Product.class);

        this.productRepository.save(product);

        return "Transaction Successfull";

    }

    @Override
    public String updateProduct(UpdateProductRequest request) {

        Product product = this.mapperService.forRequest().map(request, Product.class);

        this.productRepository.save(product);

        return "Transaction Successfull";


    }

    @Override
    public String deleteProduct(int id) throws Exception {
        this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));

        this.productRepository.deleteById(id);

        return "Transaction Successfull";
    }

    @Override
    public GetByProductResponse getByNameAndCategoryId(String productName, Integer id) {
        Product product = this.productRepository.getByNameAndCategory_Id(productName, id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        ;
        return
                this.mapperService.forResponse().map(product, GetByProductResponse.class);

    }

    @Override
    public List<GetByProductResponse> getByNameOrCategoryId(String productName, Integer id) {
        List<Product> product = this.productRepository.getByNameOrCategory_Id(productName, id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        List<GetByProductResponse> responses = new ArrayList<GetByProductResponse>();
        for (Product product1 : product) {
            responses.add(this.mapperService.forResponse().map(product1, GetByProductResponse.class));

        }


        return responses;
    }

    @Override
    public List<GetByProductResponse> getByNameIn(List<String> productNames) {
        List<Product> product = this.productRepository.getByNameIn(productNames);
        List<GetByProductResponse> responses = new ArrayList<>();

        for (Product product1 : product) {

            responses.add(this.mapperService.forResponse().map(product1, GetByProductResponse.class));

        }

        return responses;
    }

    @Override
    public List<GetByProductResponse> getByNameContains(String productName) {

        List<Product> product = this.productRepository.getByNameContains(productName);
        List<GetByProductResponse> responses = new ArrayList<>();

        for (Product product1 : product) {

            responses.add(this.mapperService.forResponse().map(product1, GetByProductResponse.class));

        }

        return responses;


    }

    @Override
    public List<GetByProductResponse> getByNameStartsWith(String productName) {

        List<Product> product = this.productRepository.getByNameStartsWith(productName);
        List<GetByProductResponse> responses = new ArrayList<>();

        for (Product product1 : product) {

            responses.add(this.mapperService.forResponse().map(product1, GetByProductResponse.class));

        }

        return responses;

    }
    @Override
    public List<ProductWithCategoryDto> getProductWithCategoryDetails(){


        return this.productRepository.getProductWithCategoryDetails();
    }
}
