package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.cart.CartItemRequestDto;
import com.gardenshop.personal.dto.cart.CartItemResponseDto;
import com.gardenshop.personal.service.interfaces.CartItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart-items")
@RequiredArgsConstructor
@Tag(name = "Товары в корзине", description = "Добавление и просмотр товаров в корзине")
public class CartItemController {

    private final CartItemService cartItemService;

    @Operation(summary = "Добавить товар в корзину")
    @PostMapping
    public ResponseEntity<CartItemResponseDto> add(@RequestBody CartItemRequestDto dto) {
        return ResponseEntity.ok(cartItemService.add(dto));
    }

    @Operation(summary = "Получить все товары по ID корзины")
    @GetMapping("/cart/{cartId}")
    public ResponseEntity<List<CartItemResponseDto>> getByCartId(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartItemService.getByCartId(cartId));
    }
}
