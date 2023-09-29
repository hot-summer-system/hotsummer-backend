package com.hotsummer.luvme.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Integer answerId;
    @Column(name = "content", columnDefinition = "nvarchar(255)")
    private String content;
    @Column(name = "linked_question_id")
    private Integer linkedQuestionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "question_id")
    private Question question;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "result_id", referencedColumnName = "result_id")
    private Result result;
}
