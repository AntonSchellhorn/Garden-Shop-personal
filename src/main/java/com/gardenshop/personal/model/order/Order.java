package com.gardenshop.personal.model.order;

import com.gardenshop.personal.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String deliveryAddress;

    private String contactPhone;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime createdAt;
}
