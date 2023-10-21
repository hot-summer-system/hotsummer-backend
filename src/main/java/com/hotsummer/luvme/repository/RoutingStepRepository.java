package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.RoutingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoutingStepRepository extends JpaRepository<RoutingProduct, Integer> {
}
