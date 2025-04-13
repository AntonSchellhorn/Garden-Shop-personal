package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.cart.CartRequestDto;
import com.gardenshop.personal.dto.cart.CartResponseDto;

public interface CartService {
    CartResponseDto create(CartRequestDto dto);
    CartResponseDto getByUserId(Long userId);
}
