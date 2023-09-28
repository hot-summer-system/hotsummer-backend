package com.hotsummer.luvme.model.mapper;

import com.hotsummer.luvme.model.entity.Answer;
import com.hotsummer.luvme.model.entity.Question;
import com.hotsummer.luvme.model.entity.Result;
import com.hotsummer.luvme.model.response.AnswerResponse;
import com.hotsummer.luvme.model.response.QuestionResponse;
import com.hotsummer.luvme.model.response.ResultResponse;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {

    public static QuestionResponse fromQuestionToQuestionResponseFullFill(Question question){
        List<AnswerResponse> answerResponseList = new ArrayList<>();
        if(question != null){
            if(question.getAnswers() != null){
                for (Answer answer : question.getAnswers()) {
                    AnswerResponse.AnswerResponseBuilder builder = AnswerResponse.builder()
                            .answerId(answer.getAnswerId())
                            .content(answer.getContent());
                    if (answer.getResult() != null) {
                        builder.resultId(answer.getResult().getResultId());
                    }
                    answerResponseList.add(builder.build());
                }
            }
        }
        return QuestionResponse.builder()
                        .questionId(question.getQuestionId())
                        .content(question.getContent())
                        .answers(answerResponseList)
                        .build();
    }

    public static ResultResponse fromResultToResultResponse(Result result){
        return result == null ? null :
                ResultResponse.builder()
                        .resultId(result.getResultId())
                        .content(result.getContent())
                        .image(result.getImage() == null ? "" : result.getImage())
                        .build();
    }

    public static AnswerResponse fromAnswerToAnswerResponse(Answer answer){
        return answer == null ? null :
                AnswerResponse.builder()
                        .answerId(answer.getAnswerId())
                        .content(answer.getContent())
                        .build();
    }
}
