package com.hotsummer.luvme.controller.api;

import com.hotsummer.luvme.controller.ResultController;
import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.ResultResponse;
import com.hotsummer.luvme.service.impl.QuestionServiceImpl;
import com.hotsummer.luvme.service.impl.ResultServiceImpl;
import com.hotsummer.luvme.service.impl.TestHistoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ResultControllerImpl implements ResultController {
    private final ResultServiceImpl resultService;
    private final TestHistoryServiceImpl testHistoryService;
    @Override
    public ResultResponse getResultById(Integer resultId) throws CustomNotFoundException, CustomBadRequestException {
        ResultResponse response = resultService.getResultById(resultId);
        testHistoryService.createNewTestHistory(response.getContent());
        return response;
    }
}
