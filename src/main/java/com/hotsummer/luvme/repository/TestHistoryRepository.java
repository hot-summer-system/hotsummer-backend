package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.TestHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TestHistoryRepository extends JpaRepository<TestHistory, Integer> {
    @Query("SELECT t.skinType FROM TestHistory t ORDER BY t.id DESC")
    String findSpecificFieldFromNewestRecord();

}
