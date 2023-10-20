package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Routing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface RoutingRepository extends JpaRepository<Routing, UUID> {
    Routing findFirstByUserActUserIdOrderByDateDesc(int userId);
}
