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
@Tag(name = "Категории", description = "CRUD-операции с категориями товаров")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Создать новую категорию")
    @PostMapping
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto request) {
        return ResponseEntity.ok(categoryService.create(request));
    }

    @Operation(summary = "Получить список всех категорий")
    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAll());
    }
}
