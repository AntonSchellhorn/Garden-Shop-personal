package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.order.OrderItemResponseDto;
import com.gardenshop.personal.model.order.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    // Преобразование OrderItem → OrderItemResponseDto
    public OrderItemResponseDto toDto(OrderItem item) {
        return new OrderItemResponseDto(
                item.getId(),                          // ID позиции
                item.getOrder().getId(),               // ID заказа
                item.getProduct().getId(),             // ID товара
                item.getProduct().getName(),           // Название товара
                item.getQuantity(),                    // Количество
                item.getPrice()                        // Цена за единицу
        );
    }
}
