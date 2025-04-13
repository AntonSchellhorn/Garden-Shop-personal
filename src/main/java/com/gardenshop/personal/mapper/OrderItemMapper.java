package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.order.OrderItemResponseDto;
import com.gardenshop.personal.model.order.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper {

    public OrderItemResponseDto toDto(OrderItem orderItem) {
        return new OrderItemResponseDto(
                orderItem.getId(),
                orderItem.getOrder().getId(),
                orderItem.getProduct().getId(),
                orderItem.getProduct().getName(),
                orderItem.getQuantity()
        );



    }
}
