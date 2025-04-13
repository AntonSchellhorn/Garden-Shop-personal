package com.gardenshop.personal.dto.order;

public record OrderItemRequestDto(
        Long orderId,
        Long productId,
        int quantity
) {}
