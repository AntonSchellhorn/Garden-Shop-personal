package com.gardenshop.personal.converter;

import com.gardenshop.personal.dto.cart.CartRequestDto;
import com.gardenshop.personal.dto.cart.CartResponseDto;
import com.gardenshop.personal.model.cart.Cart;
import com.gardenshop.personal.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class CartConverter {

    public Cart toEntity(CartRequestDto dto, User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cart;
    }

    public CartResponseDto toDto(Cart cart) {
        return new CartResponseDto(
                cart.getId(),
                cart.getUser().getEmail()
        );
    }
}
