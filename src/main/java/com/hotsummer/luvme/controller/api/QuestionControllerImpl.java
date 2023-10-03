package com.hotsummer.luvme.controller.api;

import com.hotsummer.luvme.controller.QuestionController;
import com.hotsummer.luvme.controller.api.exception.CustomBadRequestException;
import com.hotsummer.luvme.controller.api.exception.CustomNotFoundException;
import com.hotsummer.luvme.model.response.QuestionResponse;
import com.hotsummer.luvme.service.impl.QuestionServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Question API")
public class QuestionControllerImpl implements QuestionController {
    private final QuestionServiceImpl questionService;

    @Override
    public ResponseEntity<QuestionResponse> getQuestionById(Integer questionId) throws CustomNotFoundException {
        QuestionResponse responses = questionService.getQuestionById(questionId);
        return ResponseEntity.ok(responses);
    }

    @Override
    public ResponseEntity<QuestionResponse> getFirstQuestion() {
        QuestionResponse responses = questionService.getFirstQuestion();
        return ResponseEntity.ok(responses);
    }
}