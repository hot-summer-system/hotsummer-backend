package com.hotsummer.luvme.model.response;

import com.hotsummer.luvme.model.entity.Answer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse {
     private Integer questionId;
     private String content;
     List<AnswerResponse> answers;
}
