package com.gardenshop.personal.repository;

import com.gardenshop.personal.model.favorite.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}
