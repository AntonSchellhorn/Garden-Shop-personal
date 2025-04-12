package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.category.CategoryRequestDto;
import com.gardenshop.personal.dto.category.CategoryResponseDto;
import com.gardenshop.personal.model.category.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDto dto) {
        Category category = new Category();
        category.setName(dto.name());
        return category;
    }

    public CategoryResponseDto toDto(Category category) {
        return new CategoryResponseDto(
                category.getId(),  // исправляем с getCategoryid() на getId()
                category.getName()
        );
    }
}
