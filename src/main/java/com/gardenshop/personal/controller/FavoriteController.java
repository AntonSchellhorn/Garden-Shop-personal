package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.favorite.FavoriteRequestDto;
import com.gardenshop.personal.dto.favorite.FavoriteResponseDto;
import com.gardenshop.personal.service.interfaces.FavoriteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
@Tag(name = "Избранное", description = "Добавление и получение избранных товаров")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Operation(summary = "Добавить товар в избранное")
    @PostMapping
    public ResponseEntity<FavoriteResponseDto> add(@RequestBody FavoriteRequestDto dto) {
        return ResponseEntity.ok(favoriteService.add(dto));
    }

    @Operation(summary = "Получить список всех избранных товаров")
    @GetMapping
    public ResponseEntity<List<FavoriteResponseDto>> findAll() {
        return ResponseEntity.ok(favoriteService.findAll());
    }
}
