package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.converter.ProductConverter;
import com.gardenshop.personal.dto.product.ProductRequestDto;
import com.gardenshop.personal.dto.product.ProductResponseDto;
import com.gardenshop.personal.model.category.Category;
import com.gardenshop.personal.repository.CategoryRepository;
import com.gardenshop.personal.repository.ProductRepository;
import com.gardenshop.personal.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductConverter productConverter;

    @Override
    public ProductResponseDto create(ProductRequestDto dto) {
        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        return productConverter.toDto(
                productRepository.save(
                        productConverter.toEntity(dto, category)
                )
        );
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return productRepository.findAll().stream()
                .map(productConverter::toDto)
                .toList();
    }
}
