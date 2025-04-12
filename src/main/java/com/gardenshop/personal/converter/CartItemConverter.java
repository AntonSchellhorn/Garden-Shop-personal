package com.gardenshop.personal.converter;

import com.gardenshop.personal.dto.cart.CartItemRequestDto;
import com.gardenshop.personal.dto.cart.CartItemResponseDto;
import com.gardenshop.personal.model.cart.Cart;
import com.gardenshop.personal.model.cart.CartItem;
import com.gardenshop.personal.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {

    public CartItem toEntity(CartItemRequestDto dto, Cart cart, Product product) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(dto.quantity());
        return cartItem;
    }

    public CartItemResponseDto toDto(CartItem cartItem) {
        return new CartItemResponseDto(
                cartItem.getId(),
                cartItem.getProduct().getName(),
                cartItem.getQuantity()
        );
    }
}
