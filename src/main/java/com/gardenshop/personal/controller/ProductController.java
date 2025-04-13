package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.product.ProductRequestDto;
import com.gardenshop.personal.dto.product.ProductResponseDto;
import com.gardenshop.personal.service.interfaces.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "Товары", description = "Добавление, просмотр, редактирование и удаление товаров")
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Создать новый товар")
    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto dto) {
        return ResponseEntity.ok(productService.create(dto));
    }

    @Operation(summary = "Получить список всех товаров")
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @Operation(summary = "Обновить товар по ID")
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable Long id,
                                                     @RequestBody ProductRequestDto dto) {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @Operation(summary = "Удалить товар по ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Фильтрация и сортировка товаров")
    @GetMapping("/filter")
    public ResponseEntity<List<ProductResponseDto>> filterProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Boolean hasDiscount,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice,
            @RequestParam(required = false) String sort
    ) {
        return ResponseEntity.ok(productService.findFiltered(categoryId, hasDiscount, minPrice, maxPrice, sort));
    }

    @Operation(summary = "Получить товар по ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @Operation(summary = "Получить список товаров со скидкой")
    @GetMapping("/discounted")
    public ResponseEntity<List<ProductResponseDto>> getDiscounted() {
        return ResponseEntity.ok(productService.getDiscounted());
    }

    @Operation(summary = "Получить товары по ID категории")
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductResponseDto>> getByCategory(@PathVariable Long categoryId) {
        return ResponseEntity.ok(productService.getByCategoryId(categoryId));
    }

}
