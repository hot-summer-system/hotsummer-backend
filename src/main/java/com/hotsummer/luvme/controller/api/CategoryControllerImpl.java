package com.hotsummer.luvme.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.hotsummer.luvme.controller.CategoryController;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.CategoryResponse;
import com.hotsummer.luvme.service.CategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Category API")
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    @Override
    public ResponseEntity<List<CategoryResponse>> getAllCategory() throws CustomNotFoundException {
        List<CategoryResponse> categoryResponses = categoryService.GetAllCategory();
        return ResponseEntity.ok(categoryResponses);
    }

}
