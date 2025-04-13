package com.gardenshop.personal.dto.order;

public record OrderItemResponseDto(
        Long id,
        Long orderId,
        Long productId,      // ← вот это
        String productName,
        int quantity
) {}

