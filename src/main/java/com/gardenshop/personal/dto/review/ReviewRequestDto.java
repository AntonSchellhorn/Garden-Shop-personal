package com.gardenshop.personal.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ReviewRequestDto(
        @NotNull(message = "ID пользователя обязателен") Long userId,
        @NotNull(message = "ID продукта обязателен") Long productId,
        @Min(value = 1, message = "Рейтинг должен быть от 1 до 5")
        @Max(value = 5, message = "Рейтинг должен быть от 1 до 5")
        int rating,
        @NotBlank(message = "Комментарий обязателен") String comment
) {}
