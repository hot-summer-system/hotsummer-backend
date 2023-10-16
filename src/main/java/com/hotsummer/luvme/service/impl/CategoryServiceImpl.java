package com.hotsummer.luvme.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Category;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.mapper.ObjectMapper;
import com.hotsummer.luvme.model.response.CategoryResponse;
import com.hotsummer.luvme.repository.CategoryRepository;
import com.hotsummer.luvme.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> GetAllCategory() throws CustomNotFoundException {
        List<Category> responses = categoryRepository.findAll();
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : responses) {
            CategoryResponse categoryResponse = ObjectMapper.fromCategoryToCategoryResponse(category);
            categoryResponses.add(categoryResponse);
        }
        if (categoryResponses.size() == 0) {
            throw new CustomNotFoundException(
                    CustomError.builder().errorCode("404").message("not found anything").build());
        }
        return categoryResponses;
    }
}
