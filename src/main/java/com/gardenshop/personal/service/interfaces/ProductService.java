package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.product.ProductRequestDto;
import com.gardenshop.personal.dto.product.ProductResponseDto;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    ProductResponseDto create(ProductRequestDto dto);
    List<ProductResponseDto> findAll();
    ProductResponseDto update(Long id, ProductRequestDto dto);
    void delete(Long id);
    List<ProductResponseDto> findFiltered(Long categoryId, Boolean hasDiscount,BigDecimal minPrice, BigDecimal maxPrice, String sort);
    ProductResponseDto getById(Long id);
    List<ProductResponseDto> getDiscounted();
    List<ProductResponseDto> getByCategoryId(Long categoryId);

}
