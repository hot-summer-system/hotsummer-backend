package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.TestHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestHistoryRepository extends JpaRepository<TestHistory, Integer> {
}
