package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.request.RoutingProductRequest;

import java.util.List;
import java.util.UUID;

public interface RoutingStepService {
    Boolean CreateRoutingStep(List<RoutingProductRequest> routingProductRequests, Routing routing) throws CustomInternalServerException;
}
