package com.gardenshop.personal.repository;

import com.gardenshop.personal.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // Получить все заказы по ID пользователя (JPA сам сформирует SQL)
    List<Order> findAllByUserId(Long userId);
}
