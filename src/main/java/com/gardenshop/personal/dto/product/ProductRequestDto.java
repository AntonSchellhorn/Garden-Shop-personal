package com.gardenshop.personal.dto.product;

import java.math.BigDecimal;

public record ProductRequestDto(
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        BigDecimal discountPrice,
        Long categoryId
) {}
