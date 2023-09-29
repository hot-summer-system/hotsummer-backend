package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.ResultResponse;

public interface ResultService {
    ResultResponse getResultById(int resultId) throws CustomNotFoundException;
}
