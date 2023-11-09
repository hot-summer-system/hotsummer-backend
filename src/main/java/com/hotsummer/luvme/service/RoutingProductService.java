package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.request.RoutingProductRequest;

import java.util.List;

public interface RoutingProductService {
    Boolean CreateRoutingProduct(List<RoutingProductRequest> routingProductRequests, Routing routing) throws CustomInternalServerException;
}
