package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.converter.ProductConverter;
import com.gardenshop.personal.dto.product.ProductRequestDto;
import com.gardenshop.personal.dto.product.ProductResponseDto;
import com.gardenshop.personal.exception.CategoryNotFoundException;
import com.gardenshop.personal.exception.ProductNotFoundException;
import com.gardenshop.personal.model.category.Category;
import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.repository.CategoryRepository;
import com.gardenshop.personal.repository.ProductRepository;
import com.gardenshop.personal.service.interfaces.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
                .orElseThrow(CategoryNotFoundException::new);

        Product product = productConverter.toEntity(dto, category);
        product.setCreatedAt(LocalDateTime.now()); // ⬅️ Установка даты создания

        return productConverter.toDto(productRepository.save(product));
    }

    @Override
    public List<ProductResponseDto> findAll() {
        return productRepository.findAll().stream()
                .map(productConverter::toDto)
                .toList();
    }

    @Override
    public ProductResponseDto update(Long id, ProductRequestDto dto) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(CategoryNotFoundException::new);

        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setDiscountPrice(dto.discountPrice());
        product.setImageUrl(dto.imageUrl());
        product.setCategory(category);
        product.setUpdatedAt(LocalDateTime.now()); // ⬅️ (опционально)

        return productConverter.toDto(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        productRepository.delete(product);
    }

    @Override
    public List<ProductResponseDto> findFiltered(Long categoryId, Boolean hasDiscount,
                                                 BigDecimal minPrice, BigDecimal maxPrice,
                                                 String sort) {
        List<Product> products = productRepository.findFiltered(categoryId, hasDiscount, minPrice, maxPrice);

        return products.stream()
                .sorted((a, b) -> {
                    if (sort == null) return 0;
                    return switch (sort) {
                        case "price_asc" -> compareNullable(a.getPrice(), b.getPrice());
                        case "price_desc" -> compareNullable(b.getPrice(), a.getPrice());
                        case "name_asc" -> compareNullableStr(a.getName(), b.getName());
                        case "name_desc" -> compareNullableStr(b.getName(), a.getName());
                        case "newest" -> compareNullable(b.getCreatedAt(), a.getCreatedAt());
                        case "oldest" -> compareNullable(a.getCreatedAt(), b.getCreatedAt());
                        default -> 0;
                    };
                })
                .map(productConverter::toDto)
                .toList();
    }

    // 🔧 Защита от NullPointer при сортировке чисел
    private <T extends Comparable<T>> int compareNullable(T a, T b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareTo(b);
    }

    // 🔧 Защита от NullPointer при строках
    private int compareNullableStr(String a, String b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        return a.compareToIgnoreCase(b);
    }

    @Override
    public ProductResponseDto getById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        return productConverter.toDto(product);
    }

    @Override
    public List<ProductResponseDto> getDiscounted() {
        return productRepository.findAll().stream()
                .filter(p -> p.getDiscountPrice() != null && p.getDiscountPrice().compareTo(p.getPrice()) < 0)
                .map(productConverter::toDto)
                .toList();
    }

    @Override
    public List<ProductResponseDto> getByCategoryId(Long categoryId) {
        return productRepository.findAll().stream()
                .filter(p -> p.getCategory() != null && p.getCategory().getId().equals(categoryId))
                .map(productConverter::toDto)
                .toList();
    }

}
