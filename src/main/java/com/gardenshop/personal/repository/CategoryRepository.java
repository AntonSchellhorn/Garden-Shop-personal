package com.gardenshop.personal.repository;

import com.gardenshop.personal.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
