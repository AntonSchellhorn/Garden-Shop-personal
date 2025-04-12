package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.converter.CartConverter;
import com.gardenshop.personal.dto.cart.CartRequestDto;
import com.gardenshop.personal.dto.cart.CartResponseDto;
import com.gardenshop.personal.model.user.User;
import com.gardenshop.personal.repository.CartRepository;
import com.gardenshop.personal.repository.UserRepository;
import com.gardenshop.personal.service.interfaces.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final CartConverter cartConverter;

    @Override
    public CartResponseDto create(CartRequestDto dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartConverter.toDto(
                cartRepository.save(
                        cartConverter.toEntity(dto, user)
                )
        );
    }

    @Override
    public CartResponseDto getByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return cartRepository.findByUser(user)
                .map(cartConverter::toDto)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}
