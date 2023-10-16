package com.hotsummer.luvme.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.hotsummer.luvme.model.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {
    Optional<Favorite> findById(UUID id);

    @Transactional
    @Modifying
    @Query("DELETE FROM Favorite Where favoriteId = :id")
    void deleteById(UUID id);
}
