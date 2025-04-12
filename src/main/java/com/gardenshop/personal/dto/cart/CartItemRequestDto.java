package com.gardenshop.personal.dto.cart;

public record CartItemRequestDto(Long cartId, Long productId, int quantity) {
}
