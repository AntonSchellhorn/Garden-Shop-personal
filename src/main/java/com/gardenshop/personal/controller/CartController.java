package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.cart.CartRequestDto;
import com.gardenshop.personal.dto.cart.CartResponseDto;
import com.gardenshop.personal.service.interfaces.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
@Tag(name = "Корзина", description = "Операции с корзиной пользователя")
public class CartController {

    private final CartService cartService;

    @Operation(summary = "Создать корзину", description = "Создаёт новую корзину на основе переданного DTO")
    @PostMapping
    public ResponseEntity<CartResponseDto> create(@RequestBody CartRequestDto dto) {
        return ResponseEntity.ok(cartService.create(dto));
    }

    @Operation(summary = "Получить корзину по ID пользователя", description = "Возвращает корзину," +
            " связанную с указанным пользователем")
    @GetMapping("/user/{userId}")
    public ResponseEntity<CartResponseDto> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getByUserId(userId));
    }
}
