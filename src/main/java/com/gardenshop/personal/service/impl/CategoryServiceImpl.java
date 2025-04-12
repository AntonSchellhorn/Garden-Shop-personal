package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.dto.category.CategoryRequestDto;
import com.gardenshop.personal.dto.category.CategoryResponseDto;
import com.gardenshop.personal.mapper.CategoryMapper;
import com.gardenshop.personal.model.category.Category;
import com.gardenshop.personal.repository.CategoryRepository;
import com.gardenshop.personal.service.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponseDto create(CategoryRequestDto request) {
        Category saved = categoryRepository.save(categoryMapper.toEntity(request));
        return categoryMapper.toDto(saved);
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .toList();
    }
}
