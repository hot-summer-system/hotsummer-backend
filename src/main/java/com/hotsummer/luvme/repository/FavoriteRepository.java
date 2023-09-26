package com.hotsummer.luvme.repository;

import com.hotsummer.luvme.model.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
}
