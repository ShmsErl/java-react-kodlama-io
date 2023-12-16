package com.example.javareactkamp.service.concretes;

import com.example.javareactkamp.dto.categoryDto.GetCategoryResponse;
import com.example.javareactkamp.mapper.MapperService;
import com.example.javareactkamp.model.Category;
import com.example.javareactkamp.repository.CategoryRepository;
import com.example.javareactkamp.service.abstracts.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;
    private MapperService mapperService;
    @Override
    public List<GetCategoryResponse> getCategory() {
        List<Category> categories = this.categoryRepository.findAll();
        List<GetCategoryResponse> responses = new ArrayList<>();
        for (Category category : categories) {
            GetCategoryResponse categoryResponse = this.mapperService.forResponse()
                    .map(category,GetCategoryResponse.class);

            responses.add(categoryResponse);



        }
        return responses;
    }
}
