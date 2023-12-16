package com.example.javareactkamp.controller;

import com.example.javareactkamp.dto.categoryDto.GetCategoryResponse;
import com.example.javareactkamp.service.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/getall")
    public ResponseEntity<List<GetCategoryResponse>> getAll(){

        return ResponseEntity.ok(this.categoryService.getCategory());
    }
}
