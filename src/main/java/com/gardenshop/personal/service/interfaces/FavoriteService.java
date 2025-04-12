package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.favorite.FavoriteRequestDto;
import com.gardenshop.personal.dto.favorite.FavoriteResponseDto;

import java.util.List;

public interface FavoriteService {
    FavoriteResponseDto add(FavoriteRequestDto dto);
    List<FavoriteResponseDto> findAll();
}
