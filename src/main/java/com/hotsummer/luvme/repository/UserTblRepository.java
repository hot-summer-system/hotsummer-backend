package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.UserTbl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTblRepository extends JpaRepository<UserTbl, Integer> {
    Optional<UserTbl> findByEmail(String email);
}
