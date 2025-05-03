package com.gardenshop.personal.dto.order;

import java.math.BigDecimal;

public record OrderItemResponseDto(
        Long id,               // ID позиции
        Long orderId,          // ID заказа
        Long productId,        // ID товара
        String productName,    // Название
        int quantity,          // Кол-во
        BigDecimal price       // Цена за штуку
) {
}
