package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.ProductIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductIngredientRepository extends JpaRepository<ProductIngredient, Integer> {
}
