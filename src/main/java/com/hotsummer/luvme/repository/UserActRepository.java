package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.UserTbl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserActRepository extends JpaRepository<UserTbl, Integer> {
}
