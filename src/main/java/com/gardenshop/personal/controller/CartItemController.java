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
@Tag(name = "Товары в корзине", description = "Управление товарами внутри корзины")
public class CartItemController {

    private final CartItemService cartItemService;

    @Operation(summary = "Добавить товар в корзину", description = "Добавляет новый товар в корзину")
    @PostMapping
    public ResponseEntity<CartItemResponseDto> add(@RequestBody CartItemRequestDto dto) {
        return ResponseEntity.ok(cartItemService.add(dto));
    }

    @Operation(summary = "Получить все товары по ID корзины", description =
            "Возвращает список товаров в указанной корзине")
    @GetMapping("/cart/{cartId}")
    public ResponseEntity<List<CartItemResponseDto>> getByCartId(@PathVariable Long cartId) {
        return ResponseEntity.ok(cartItemService.getByCartId(cartId));
    }

    @Operation(summary = "Увеличить количество товара", description =
            "Увеличивает количество товара в корзине на заданное значение")
    @PatchMapping("/{id}/increase")
    public ResponseEntity<CartItemResponseDto> increaseQuantity(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") int amount) {
        return ResponseEntity.ok(cartItemService.increaseQuantity(id, amount));
    }

    @Operation(summary = "Уменьшить количество товара", description =
            "Уменьшает количество товара в корзине на заданное значение")
    @PatchMapping("/{id}/decrease")
    public ResponseEntity<CartItemResponseDto> decreaseQuantity(
            @PathVariable Long id,
            @RequestParam(defaultValue = "1") int amount) {
        return ResponseEntity.ok(cartItemService.decreaseQuantity(id, amount));
    }

    @Operation(summary = "Удалить товар из корзины", description =
            "Полностью удаляет товар из корзины")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cartItemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
