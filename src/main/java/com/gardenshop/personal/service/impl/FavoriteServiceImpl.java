package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.converter.FavoriteConverter;
import com.gardenshop.personal.dto.favorite.FavoriteRequestDto;
import com.gardenshop.personal.dto.favorite.FavoriteResponseDto;
import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.model.user.User;
import com.gardenshop.personal.repository.FavoriteRepository;
import com.gardenshop.personal.repository.ProductRepository;
import com.gardenshop.personal.repository.UserRepository;
import com.gardenshop.personal.service.interfaces.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final FavoriteConverter favoriteConverter;

    @Override
    public FavoriteResponseDto add(FavoriteRequestDto dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(dto.productId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return favoriteConverter.toDto(
                favoriteRepository.save(
                        favoriteConverter.toEntity(dto, user, product)
                )
        );
    }

    @Override
    public List<FavoriteResponseDto> findAll() {
        return favoriteRepository.findAll().stream()
                .map(favoriteConverter::toDto)
                .toList();
    }
}
