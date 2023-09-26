package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
