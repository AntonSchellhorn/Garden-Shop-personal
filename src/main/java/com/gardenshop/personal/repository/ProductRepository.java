package com.gardenshop.personal.repository;

import com.gardenshop.personal.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT p FROM Product p
            WHERE (:categoryId IS NULL OR p.category.id = :categoryId)
              AND (:hasDiscount IS NULL OR 
                   (:hasDiscount = TRUE AND p.discountPrice IS NOT NULL AND p.discountPrice < p.price) OR
                   (:hasDiscount = FALSE AND (p.discountPrice IS NULL OR p.discountPrice >= p.price)))
              AND (:minPrice IS NULL OR p.price >= :minPrice)
              AND (:maxPrice IS NULL OR p.price <= :maxPrice)
            """)
    List<Product> findFiltered(Long categoryId, Boolean hasDiscount, BigDecimal minPrice, BigDecimal maxPrice);
}
