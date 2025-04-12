package com.gardenshop.personal.repository;

import com.gardenshop.personal.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Можно добавить нужные запросы
}
