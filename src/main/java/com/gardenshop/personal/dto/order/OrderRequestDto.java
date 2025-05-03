package com.gardenshop.personal.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * DTO для создания заказа. Используется при оформлении заказа пользователем.
 */
public record OrderRequestDto(
        Long userId,               // ID пользователя
        LocalDateTime orderDate,   // Дата оформления
        BigDecimal totalPrice,     // Общая сумма
        String deliveryAddress,    // Адрес доставки
        String contactPhone,       // Телефон
        String deliveryMethod,     // Способ доставки (курьер, самовывоз и т.д.)
        String deliveryCompany,    // Название службы доставки (например, DHL)
        String trackingLink        // Ссылка для отслеживания посылки
) {
}
