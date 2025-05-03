package com.gardenshop.personal.dto.order;

import com.gardenshop.personal.model.order.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * DTO для ответа с полной информацией о заказе.
 */
public record OrderResponseDto(
        Long id,                             // ID заказа
        LocalDateTime orderDate,             // Дата оформления
        BigDecimal totalPrice,               // Общая сумма
        String deliveryAddress,              // Адрес
        String contactPhone,                 // Телефон
        String deliveryMethod,               // Способ доставки
        String deliveryCompany,              // ✅ Название службы доставки
        String trackingLink,                 // ✅ Ссылка на отслеживание
        OrderStatus status,                  // Статус заказа
        String userEmail,                    // Email пользователя
        List<OrderItemResponseDto> items     // Список позиций заказа
) {
}
