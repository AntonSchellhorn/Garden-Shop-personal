package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.order.OrderRequestDto;
import com.gardenshop.personal.dto.order.OrderResponseDto;
import com.gardenshop.personal.model.order.Order;
import com.gardenshop.personal.model.user.User;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public Order toEntity(OrderRequestDto dto, User user) {
        Order order = new Order();
        order.setOrderDate(dto.orderDate());
        order.setTotalPrice(dto.totalPrice());
        order.setDeliveryAddress(dto.deliveryAddress());
        order.setContactPhone(dto.contactPhone());
        order.setUser(user);
        return order;
    }

    public OrderResponseDto toDto(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getOrderDate(),
                order.getTotalPrice(),
                order.getUser().getEmail()
        );
    }
}
