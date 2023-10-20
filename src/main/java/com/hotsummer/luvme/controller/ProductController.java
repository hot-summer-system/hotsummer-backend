package com.hotsummer.luvme.controller;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.ProductResponse;
import com.hotsummer.luvme.model.response.QuestionResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("api/v1/product")
public interface ProductController {
    @Operation(summary = "Get Product By Suitable Skin", description = "Get Product List With Suitable Skin Type In Test History")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Fetching Success"),
            @ApiResponse(responseCode = "404", description = "No Product Suitable"),
            @ApiResponse(responseCode = "500", description = "Exception Error"),
    })
    @GetMapping("/suitableSkinType/")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<List<ProductResponse>> getProductWithSuitableSkinType()
            throws CustomNotFoundException, CustomInternalServerException;

    @Operation(summary = "Get Product By Id", description = "Get Product With Product Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Fetching Success"),
            @ApiResponse(responseCode = "404", description = "No Product Found"),
            @ApiResponse(responseCode = "500", description = "Exception Error"),
    })
    @GetMapping("/{productId}")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") String productId)
            throws CustomBadRequestException,CustomNotFoundException, CustomInternalServerException;
    @Operation(summary = "Get Product By Category", description = "Get Product List With Category Code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product Fetching Success"),
            @ApiResponse(responseCode = "404", description = "No Product Suitable"),
            @ApiResponse(responseCode = "500", description = "Exception Error"),
    })
    @GetMapping("/category/")
    @PreAuthorize("hasAuthority('CUSTOMER')")
    public ResponseEntity<List<ProductResponse>> getProductWithCategory(@RequestParam String categoryCode)
            throws CustomNotFoundException, CustomInternalServerException, CustomBadRequestException;
}
