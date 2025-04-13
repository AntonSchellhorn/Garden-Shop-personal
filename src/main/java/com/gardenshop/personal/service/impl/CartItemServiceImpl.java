package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.converter.CartItemConverter;
import com.gardenshop.personal.dto.cart.CartItemRequestDto;
import com.gardenshop.personal.dto.cart.CartItemResponseDto;
import com.gardenshop.personal.model.cart.Cart;
import com.gardenshop.personal.model.cart.CartItem;
import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.repository.CartItemRepository;
import com.gardenshop.personal.repository.CartRepository;
import com.gardenshop.personal.repository.ProductRepository;
import com.gardenshop.personal.service.interfaces.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemConverter cartItemConverter;

    @Override
    public CartItemResponseDto add(CartItemRequestDto dto) {
        Cart cart = cartRepository.findById(dto.cartId())
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Product product = productRepository.findById(dto.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = cartItemConverter.toEntity(dto, cart, product);
        return cartItemConverter.toDto(cartItemRepository.save(cartItem));
    }

    @Override
    public List<CartItemResponseDto> getByCartId(Long cartId) {
        return cartItemRepository.findAll().stream()
                .filter(cartItem -> cartItem.getCart().getId().equals(cartId))
                .map(cartItemConverter::toDto)
                .toList();
    }
}
