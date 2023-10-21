package com.hotsummer.luvme.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.CategoryResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("api/v1/category")

public interface CategoryController {
    @Operation(summary = "Get All Category", description = "Get all category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get all category successfully"),
            @ApiResponse(responseCode = "404", description = "Not found category"),
    })
    @GetMapping("/getAll")
    public ResponseEntity<List<CategoryResponse>> getAllCategory()
            throws CustomNotFoundException;
}
