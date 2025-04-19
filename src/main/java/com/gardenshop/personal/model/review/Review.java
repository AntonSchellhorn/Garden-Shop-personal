package com.gardenshop.personal.model.review;

import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating; // Оценка от 1 до 5

    private String comment; // Текст отзыва

    private LocalDateTime createdAt; // Дата создания отзыва

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Кто оставил отзыв

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // К какому товару отзыв
}
