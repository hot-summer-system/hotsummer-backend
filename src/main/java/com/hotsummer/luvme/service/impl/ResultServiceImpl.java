package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Result;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.mapper.ObjectMapper;
import com.hotsummer.luvme.model.response.ResultResponse;
import com.hotsummer.luvme.repository.QuestionRepository;
import com.hotsummer.luvme.repository.ResultRepository;
import com.hotsummer.luvme.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ResultServiceImpl implements ResultService {
    private final ResultRepository resultRepository;
    @Override
    public ResultResponse getResultById(int resultId) throws CustomNotFoundException {
        Result result = resultRepository.findResultByResultId(resultId)
                .orElseThrow(() -> new CustomNotFoundException(
                        CustomError.builder().message("No Result Found").errorCode("404").field("Result").build()));
        return ObjectMapper.fromResultToResultResponse(result);
    }
}
