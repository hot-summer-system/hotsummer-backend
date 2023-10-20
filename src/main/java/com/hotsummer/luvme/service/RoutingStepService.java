package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.entity.RoutingStep;

import java.util.List;
import java.util.UUID;

public interface RoutingStepService {
    List<RoutingStep> CreateRoutingStep(List<UUID> productId) throws CustomInternalServerException;

}
