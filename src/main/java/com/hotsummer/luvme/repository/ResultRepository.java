package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResultRepository extends JpaRepository<Result, Integer> {
    Optional<Result> findResultByResultId(int resultId);
}
