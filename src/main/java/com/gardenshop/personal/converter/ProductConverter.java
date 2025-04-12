package com.gardenshop.personal.converter;

import com.gardenshop.personal.dto.product.ProductRequestDto;
import com.gardenshop.personal.dto.product.ProductResponseDto;
import com.gardenshop.personal.model.category.Category;
import com.gardenshop.personal.model.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductConverter {

    public Product toEntity(ProductRequestDto dto, Category category) {
        Product product = new Product();
        product.setName(dto.name());
        product.setDescription(dto.description());
        product.setPrice(dto.price());
        product.setImageUrl(dto.imageUrl());
        product.setDiscountPrice(dto.discountPrice());
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
                product.getCategory().getName()
        );
    }
}
