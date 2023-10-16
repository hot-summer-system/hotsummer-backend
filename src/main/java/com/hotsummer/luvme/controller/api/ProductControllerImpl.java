package com.hotsummer.luvme.controller.api;

import com.hotsummer.luvme.controller.ProductController;
import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.response.ProductResponse;
import com.hotsummer.luvme.service.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Product Action API")
public class ProductControllerImpl implements ProductController {
    private final ProductServiceImpl productService;
    @Override
    public ResponseEntity<List<ProductResponse>> getProductWithSuitableSkinType() throws CustomNotFoundException, CustomInternalServerException {
        List<ProductResponse> response = productService.getProductWithSuitableSkinType();
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getProductWithCategory(String categoryCode) throws CustomNotFoundException, CustomInternalServerException, CustomBadRequestException {
        if (categoryCode == null){
            throw new CustomBadRequestException(CustomError.builder().message("Category code is null").errorCode("400").build());
        }
        List<ProductResponse> response = productService.getProductWithCategory(categoryCode);
        return ResponseEntity.ok(response);
    }
}
