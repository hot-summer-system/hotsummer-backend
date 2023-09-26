package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
