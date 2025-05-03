package com.gardenshop.personal.model.order;

import com.gardenshop.personal.model.user.User;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate; // Дата оформления

    private BigDecimal totalPrice;   // Общая сумма заказа

    private String deliveryAddress;  // Адрес доставки

    private String contactPhone;     // Телефон для связи

    private String deliveryMethod;   // Метод доставки (самовывоз, курьер и т.д.)

    @Enumerated(EnumType.STRING)
    private OrderStatus status;      // Статус заказа (AWAITING_PAYMENT, PAID и т.д.)

    private String deliveryCompany;  // Название службы доставки (например, DHL, СДЭК)

    private String trackingLink;     // Ссылка на отслеживание (если есть)

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;               // Пользователь, оформивший заказ

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems; // Позиции в заказе
}
