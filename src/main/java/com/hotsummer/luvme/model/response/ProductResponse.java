package com.hotsummer.luvme.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private UUID productId;
    private String productName;
    private String productImage;
    private String description;

    List<ProductSkinTypeResponse> productSkinTypeResponses;
    List<ProductCategoryResponse> productCategoryResponses;
    List<ProductCharacteristicsResponse> productCharacteristicsResponses;
    List<ProductIngredientResponse> productIngredientResponses;

}
