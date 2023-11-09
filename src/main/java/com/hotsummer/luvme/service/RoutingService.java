package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomInternalServerException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Routing;
import com.hotsummer.luvme.model.response.RoutingResponse;

public interface RoutingService {
    Routing ModifyRoutine(String description, String dateReminder) throws CustomInternalServerException;
    Boolean CreateRoutingScheduling(int userId) throws CustomInternalServerException;
    Boolean FinishedRouting(int userId) throws CustomInternalServerException;
    RoutingResponse GetRouting(int userId) throws CustomNotFoundException;
}
