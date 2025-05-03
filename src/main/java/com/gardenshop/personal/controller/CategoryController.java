package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.category.CategoryRequestDto;
import com.gardenshop.personal.dto.category.CategoryResponseDto;
import com.gardenshop.personal.service.interfaces.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@Tag(name = "Категории", description = "Управление категориями товаров")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Создать категорию", description = "Создает новую категорию товаров")
    @PostMapping
    public ResponseEntity<CategoryResponseDto> create(@RequestBody CategoryRequestDto request) {
        return ResponseEntity.ok(categoryService.create(request));
    }

    @Operation(summary = "Получить все категории", description = "Возвращает список всех категорий")
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAll() {
        return ResponseEntity.ok(categoryService.getAll());
    }

    @Operation(summary = "Обновить категорию", description = "Обновляет данные категории по её ID")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> update(@PathVariable Long id,
                                                      @RequestBody CategoryRequestDto request) {
        return ResponseEntity.ok(categoryService.update(id, request));
    }

    @Operation(summary = "Удалить категорию", description = "Удаляет категорию по её ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
