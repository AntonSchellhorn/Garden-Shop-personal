package com.gardenshop.personal.converter;

import com.gardenshop.personal.dto.category.CategoryRequestDto;
import com.gardenshop.personal.dto.category.CategoryResponseDto;
import com.gardenshop.personal.model.category.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public Category toEntity(CategoryRequestDto dto) {
        Category category = new Category();
        category.setName(dto.name());
        return category;
    }

    public CategoryResponseDto toDto(Category category) {
        return new CategoryResponseDto(
                category.getId(),
                category.getName()
        );
    }
}
