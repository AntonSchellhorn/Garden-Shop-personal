package com.gardenshop.personal.dto.cart;

public record CartItemResponseDto(
        Long id,
        String productName,
        int quantity
) {}
