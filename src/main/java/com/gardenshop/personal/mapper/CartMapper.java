package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.cart.CartResponseDto;
import com.gardenshop.personal.model.cart.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public CartResponseDto toDto(Cart cart) {
        return new CartResponseDto(
                cart.getId(),
                cart.getUser().getEmail() // userEmail
        );
    }
}
