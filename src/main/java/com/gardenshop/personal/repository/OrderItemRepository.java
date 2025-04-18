package com.gardenshop.personal.repository;

import com.gardenshop.personal.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(Long orderId); // Для получения всех позиций по заказу
}
