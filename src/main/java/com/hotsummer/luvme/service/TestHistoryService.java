package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.model.entity.TestHistory;

public interface TestHistoryService {
    TestHistory createNewTestHistory(String skinType) throws CustomBadRequestException;
}
