package com.gardenshop.personal.dto.product;

import java.math.BigDecimal;

public record ProductResponseDto(
        Long id,
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        BigDecimal discountPrice,
        String categoryName,
        Integer salesCount
) {

}
