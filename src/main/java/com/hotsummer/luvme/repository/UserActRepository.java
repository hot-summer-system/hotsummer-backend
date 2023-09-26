package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.UserAct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActRepository extends JpaRepository<UserAct, Integer> {
}
