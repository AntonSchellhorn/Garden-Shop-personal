package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.cart.CartItemRequestDto;
import com.gardenshop.personal.dto.cart.CartItemResponseDto;

import java.util.List;

public interface CartItemService {
    CartItemResponseDto add(CartItemRequestDto dto);
    List<CartItemResponseDto> getByCartId(Long cartId);
}
