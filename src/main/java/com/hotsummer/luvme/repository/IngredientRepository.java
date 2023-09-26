package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
