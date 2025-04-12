package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.cart.CartRequestDto;
import com.gardenshop.personal.dto.cart.CartResponseDto;
import com.gardenshop.personal.service.interfaces.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartResponseDto> create(@RequestBody CartRequestDto dto) {
        return ResponseEntity.ok(cartService.create(dto));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<CartResponseDto> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(cartService.getByUserId(userId));
    }
}
