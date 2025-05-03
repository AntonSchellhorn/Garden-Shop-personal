package com.gardenshop.personal.dto.favorite;

public record FavoriteRequestDto(
        Long userId,
        Long productId) {
}
