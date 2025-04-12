package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.cart.CartItemRequestDto;
import com.gardenshop.personal.dto.cart.CartItemResponseDto;
import com.gardenshop.personal.service.interfaces.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cart-items")
@RequiredArgsConstructor
public class CartItemController {

    private final CartItemService cartItemService;

    @PostMapping
    public ResponseEntity<CartItemResponseDto> add(@RequestBody CartItemRequestDto dto) {
        return ResponseEntity.ok(cartItemService.add(dto));
    }

    @GetMapping("/cart/{cartId}")
    public ResponseEntity<List<CartItemResponseDto>> getByCartId(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartItemService.getByCartId(cartId));
    }
}
