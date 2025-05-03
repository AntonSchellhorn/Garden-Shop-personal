package com.gardenshop.personal.service.scheduler;

import com.gardenshop.personal.model.order.Order;
import com.gardenshop.personal.model.order.OrderStatus;
import com.gardenshop.personal.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderStatusScheduler {

    private final OrderRepository orderRepository;

    @Scheduled(fixedRate = 30_000)
    public void updateOrderStatuses() {
        List<Order> orders = orderRepository.findAll();

        for (Order order : orders) {
            LocalDateTime orderDate = order.getOrderDate();
            Duration duration = Duration.between(orderDate, LocalDateTime.now());

            switch (order.getStatus()) {
                case AWAITING_PAYMENT -> {
                    if (duration.toMinutes() >= 15) {
                        order.setStatus(OrderStatus.CANCELLED);
                        log.info("❌ Заказ #{} отменён (оплата не поступила за 15 минут)", order.getId());
                    }
                }

                case PAID -> {
                    if (duration.toHours() >= 1) {
                        order.setStatus(OrderStatus.SHIPPED);
                        order.setDeliveryCompany("DPD"); // можно заменить логикой
                        order.setTrackingLink("https://tracking.example.com/" + order.getId());
                        log.info("📤 Заказ #{} отправлен в доставку (SHIPPED)", order.getId());
                    }
                }

                case SHIPPED -> {
                    if (duration.toHours() >= 2) {
                        order.setStatus(OrderStatus.IN_DELIVERY);
                        log.info("🚚 Заказ #{} передан в руки курьера (IN_DELIVERY)", order.getId());
                    }
                }

                case IN_DELIVERY -> {
                    if (duration.toHours() >= 4) {
                        order.setStatus(OrderStatus.DELIVERED);
                        log.info("✅ Заказ #{} доставлен (DELIVERED)", order.getId());
                    }
                }

                default -> {
                    // Статусы CREATED, CANCELLED, DELIVERED — не меняем
                }
            }
        }

        orderRepository.saveAll(orders);
    }
}
