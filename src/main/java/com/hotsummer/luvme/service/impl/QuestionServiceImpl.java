package com.hotsummer.luvme.service.impl;

import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.entity.Question;
import com.hotsummer.luvme.model.error.CustomError;
import com.hotsummer.luvme.model.error.ErrorMessage;
import com.hotsummer.luvme.model.mapper.ObjectMapper;
import com.hotsummer.luvme.model.response.AnswerResponse;
import com.hotsummer.luvme.model.response.QuestionResponse;
import com.hotsummer.luvme.repository.QuestionRepository;
import com.hotsummer.luvme.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public QuestionResponse getQuestionById(int questionId) throws CustomNotFoundException {
        Question question = questionRepository.findQuestionByQuestionId(questionId)
                .orElseThrow(() -> new CustomNotFoundException(CustomError.builder().errorCode("404").message("Question Not Exist").build()));
        return ObjectMapper.fromQuestionToQuestionResponseFullFill(question);
    }

    @Override
    public QuestionResponse getFirstQuestion() {
        Question question = questionRepository.getFirstQuestion();
        return ObjectMapper.fromQuestionToQuestionResponseFullFill(question);
    }
}
