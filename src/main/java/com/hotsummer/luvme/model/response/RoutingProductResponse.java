package com.hotsummer.luvme.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoutingProductResponse {
    private int routingProductId;
    private int orderProduct;

    private ProductResponse productResponse;
}
