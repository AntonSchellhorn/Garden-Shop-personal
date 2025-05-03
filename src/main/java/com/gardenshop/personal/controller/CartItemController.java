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
@Tag(name = "Cart Items", description = "Managing items inside the shopping cart")
public class CartItemController {

    private final CartItemService cartItemService;

    // Добавление товара в корзину
    @Operation(summary = "Add item to cart")
    @PostMapping
    public ResponseEntity<CartItemResponseDto> add(@RequestBody CartItemRequestDto dto) {
        return ResponseEntity.ok(cartItemService.add(dto));
    }

    // Получение всех товаров по ID корзины
    @Operation(summary = "Get all items by cart ID")
    @GetMapping("/cart/{cartId}")
    public ResponseEntity<List<CartItemResponseDto>> getByCartId(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartItemService.getByCartId(cartId));
    }

    // Увеличение количества товара в корзине
    @Operation(summary = "Increase item quantity in cart")
    @PatchMapping("/{id}/increase")
    public ResponseEntity<CartItemResponseDto> increaseQuantity(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") int amount) {
        return ResponseEntity.ok(cartItemService.increaseQuantity(id, amount));
    }

    // Уменьшение количества товара в корзине
    @Operation(summary = "Decrease item quantity in cart")
    @PatchMapping("/{id}/decrease")
    public ResponseEntity<CartItemResponseDto> decreaseQuantity(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") int amount) {
        return ResponseEntity.ok(cartItemService.decreaseQuantity(id, amount));
    }

    // Полное удаление товара из корзины
    @Operation(summary = "Remove item from cart completely")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
