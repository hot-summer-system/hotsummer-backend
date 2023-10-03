package com.hotsummer.luvme.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IngredientResponse {
    private int ingredientId;
    private String name;
    private String description;
}
