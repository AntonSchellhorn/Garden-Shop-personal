package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.category.CategoryRequestDto;
import com.gardenshop.personal.dto.category.CategoryResponseDto;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto create(CategoryRequestDto request);
    List<CategoryResponseDto> getAll();

    CategoryResponseDto update(Long id, CategoryRequestDto request);

    void delete(Long id);

}

