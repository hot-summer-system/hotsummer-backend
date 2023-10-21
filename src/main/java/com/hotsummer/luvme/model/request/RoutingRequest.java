package com.hotsummer.luvme.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@Data
public class RoutingRequest {
    private String description;
    private String dateReminder;
    List<RoutingProductRequest> routingProductRequests;
}
