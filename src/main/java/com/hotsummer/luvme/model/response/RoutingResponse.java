package com.hotsummer.luvme.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoutingResponse {
    private String routingType;
    private Date date;
    private String description;
    private String dateReminder;
    private boolean isDone;

    List<RoutingProductResponse> routingProductResponses;

}
