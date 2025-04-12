package com.gardenshop.personal.repository;

import com.gardenshop.personal.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
