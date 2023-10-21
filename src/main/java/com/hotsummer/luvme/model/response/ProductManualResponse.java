package com.hotsummer.luvme.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductManualResponse {
    private int productManualId;
    private int orderStep;
    private String description;
}
