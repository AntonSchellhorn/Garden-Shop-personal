package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.model.order.Order;
import com.gardenshop.personal.model.order.OrderStatus;
import com.gardenshop.personal.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderStatusScheduler {

    private final OrderRepository orderRepository;

    @Scheduled(fixedRate = 30000) // каждые 30 секунд
    public void updateOrderStatuses() {
        List<Order> orders = orderRepository.findAll();

        for (Order order : orders) {
            OrderStatus current = order.getStatus();

            // ⏳ Сначала проверим просроченность оплаты
            if (current == OrderStatus.AWAITING_PAYMENT &&
                    order.getOrderDate().plusMinutes(1).isBefore(LocalDateTime.now())) {
                order.setStatus(OrderStatus.CANCELLED);
                orderRepository.save(order);
                log.info("Заказ {} отменён (ожидание оплаты превысило 1 минуту)", order.getId());
                continue; // ⬅️ Пропускаем переход дальше
            }

            // 🔁 Потом обычный переход по статусам
            OrderStatus next = getNextStatus(current);

            if (next != null) {
                order.setStatus(next);
                orderRepository.save(order);
                log.info("Обновлён заказ {}: {} → {}", order.getId(), current, next);
            }
        }

    }

    private OrderStatus getNextStatus(OrderStatus status) {
        return switch (status) {
            case CREATED -> OrderStatus.AWAITING_PAYMENT;
            case AWAITING_PAYMENT -> OrderStatus.PAID;
            case PAID -> OrderStatus.IN_DELIVERY;
            case IN_DELIVERY -> OrderStatus.DELIVERED;
            case DELIVERED, CANCELLED -> null;
        };
    }
}
