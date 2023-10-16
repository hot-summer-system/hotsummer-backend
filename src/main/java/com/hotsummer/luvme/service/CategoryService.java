package com.hotsummer.luvme.service;

import java.util.List;

import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.CategoryResponse;

public interface CategoryService {
    List<CategoryResponse> GetAllCategory() throws CustomNotFoundException;
}
