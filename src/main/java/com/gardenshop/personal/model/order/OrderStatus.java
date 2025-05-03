package com.gardenshop.personal.model.order;

/**
 * Перечисление всех возможных статусов заказа.
 * Используется для отображения этапов обработки и доставки.
 */
public enum OrderStatus {
    CREATED,            // Заказ создан вручную, но ещё не оплачен
    AWAITING_PAYMENT,   // Ожидает оплаты
    PAID,               // Оплачен
    SHIPPED,            // Отправлен в доставку (добавлен новый статус)
    IN_DELIVERY,        // В процессе доставки
    DELIVERED,          // Доставлен
    CANCELLED           // Отменён
}
