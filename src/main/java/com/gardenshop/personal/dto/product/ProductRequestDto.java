package com.gardenshop.personal.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record ProductRequestDto(
        @NotBlank(message = "Название товара обязательно") String name,
        @NotBlank(message = "Описание товара обязательно") String description,
        @NotNull(message = "Цена товара обязательна") BigDecimal price,
        BigDecimal discountPrice,
        @NotBlank(message = "Ссылка на изображение обязательна") String imageUrl,
        @NotNull(message = "ID категории обязательно") Long categoryId
) {}
