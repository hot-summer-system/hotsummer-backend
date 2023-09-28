package com.hotsummer.luvme.service;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Question;
import com.hotsummer.luvme.model.response.QuestionResponse;

public interface QuestionService {
    QuestionResponse getQuestionById(int questionId) throws CustomNotFoundException;
    QuestionResponse getFirstQuestion();
}
