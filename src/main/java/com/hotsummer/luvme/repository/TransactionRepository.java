package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
}
