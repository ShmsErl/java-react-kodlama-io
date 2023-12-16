package com.example.javareactkamp.service.abstracts;

import com.example.javareactkamp.dto.categoryDto.GetCategoryResponse;
import com.example.javareactkamp.model.Category;

import java.util.List;

public interface CategoryService {

   List<GetCategoryResponse> getCategory();
}
