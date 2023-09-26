package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepostiory extends JpaRepository<Answer, Integer> {
}
