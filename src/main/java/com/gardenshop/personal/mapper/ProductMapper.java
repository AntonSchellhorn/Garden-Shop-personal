package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.product.ProductRequestDto;
import com.gardenshop.personal.dto.product.ProductResponseDto;
import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.model.category.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDto requestDto, Category category) {
        Product product = new Product();
        product.setName(requestDto.name());
        product.setDescription(requestDto.description());
        product.setPrice(requestDto.price());
        product.setDiscountPrice(requestDto.discountPrice());
        product.setImageUrl(requestDto.imageUrl());
        product.setCategory(category);
        return product;
    }

    public ProductResponseDto toDto(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImageUrl(),
                product.getDiscountPrice(),
                product.getCategory().getName(),
                product.getSalesCount()
        );
    }
}
