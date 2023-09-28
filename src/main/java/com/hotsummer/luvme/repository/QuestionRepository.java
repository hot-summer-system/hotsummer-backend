package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<Question> findQuestionByQuestionId(int questionId);
    @Query("SELECT q FROM Question q WHERE q.questionId NOT IN (SELECT a.linkedQuestionId FROM Answer a WHERE a.linkedQuestionId IS NOT NULL)")
    Question getFirstQuestion();}
