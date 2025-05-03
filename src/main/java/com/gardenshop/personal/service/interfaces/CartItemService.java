package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.cart.CartItemRequestDto;
import com.gardenshop.personal.dto.cart.CartItemResponseDto;

import java.util.List;

public interface CartItemService {
    CartItemResponseDto add(CartItemRequestDto dto);

    List<CartItemResponseDto> getByCartId(Long cartId);
    // Увеличить количество товара в корзине
    CartItemResponseDto increaseQuantity(Long id, int amount);

    // Уменьшить количество товара в корзине
    CartItemResponseDto decreaseQuantity(Long id, int amount);

    // Удалить товар из корзины полностью
    void deleteById(Long id);

}
