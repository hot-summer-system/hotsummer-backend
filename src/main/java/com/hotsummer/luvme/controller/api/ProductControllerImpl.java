package com.hotsummer.luvme.controller.api;

import com.hotsummer.luvme.controller.ProductController;
import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
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
}
