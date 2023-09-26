package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
