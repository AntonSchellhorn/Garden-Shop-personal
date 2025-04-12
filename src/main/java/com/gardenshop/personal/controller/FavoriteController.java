package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.favorite.FavoriteRequestDto;
import com.gardenshop.personal.dto.favorite.FavoriteResponseDto;
import com.gardenshop.personal.service.interfaces.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @PostMapping
    public ResponseEntity<FavoriteResponseDto> add(@RequestBody FavoriteRequestDto dto) {
        return ResponseEntity.ok(favoriteService.add(dto));
    }

    @GetMapping
    public ResponseEntity<List<FavoriteResponseDto>> findAll() {
        return ResponseEntity.ok(favoriteService.findAll());
    }
}
