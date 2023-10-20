package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.RoutingStep;
import com.hotsummer.luvme.model.response.RoutingResponse;

import java.util.List;

public interface RoutingService {
    Boolean CreateRouting (String description, String dateReminder, List<RoutingStep> routingSteps) throws CustomInternalServerException;
    Boolean CreateRoutingScheduling(int userId) throws CustomInternalServerException;
    Boolean UpdateRouting(int userId) throws CustomInternalServerException;
    RoutingResponse GetRouting(int userId) throws CustomNotFoundException;
}
