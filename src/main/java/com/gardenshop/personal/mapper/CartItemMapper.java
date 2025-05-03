package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.cart.CartItemRequestDto;
import com.gardenshop.personal.dto.cart.CartItemResponseDto;
import com.gardenshop.personal.model.cart.Cart;
import com.gardenshop.personal.model.cart.CartItem;
import com.gardenshop.personal.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class CartItemMapper {

    public CartItem toEntity(CartItemRequestDto requestDto, Cart cart, Product product) {
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(requestDto.quantity());
        return cartItem;
    }

    public CartItemResponseDto toDto(CartItem cartItem) {
        return new CartItemResponseDto(
                cartItem.getId(),
                cartItem.getProduct().getName(), // productName
                cartItem.getQuantity()
        );
    }
}
