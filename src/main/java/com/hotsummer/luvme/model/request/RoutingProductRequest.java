package com.hotsummer.luvme.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Data
public class RoutingProductRequest {
    private UUID productId;
    private int orderProduct;
}
