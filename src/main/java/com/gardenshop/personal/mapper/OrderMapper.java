package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.order.OrderResponseDto;
import com.gardenshop.personal.dto.order.OrderRequestDto;
import com.gardenshop.personal.dto.order.OrderItemResponseDto;
import com.gardenshop.personal.model.order.Order;
import com.gardenshop.personal.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderItemMapper orderItemMapper;

    // Преобразование DTO → Order (из запроса)
    public Order toEntity(OrderRequestDto dto, User user) {
        Order order = new Order();
        order.setOrderDate(dto.orderDate());
        order.setTotalPrice(dto.totalPrice());
        order.setDeliveryAddress(dto.deliveryAddress());
        order.setContactPhone(dto.contactPhone());
        order.setDeliveryMethod(dto.deliveryMethod());
        order.setDeliveryCompany(dto.deliveryCompany()); // ✅ служба доставки
        order.setTrackingLink(dto.trackingLink());       // ✅ ссылка для отслеживания
        order.setUser(user);
        return order;
    }

    // Преобразование Order → DTO (для ответа)
    public OrderResponseDto toDto(Order order) {
        List<OrderItemResponseDto> items = order.getOrderItems().stream()
                .map(orderItemMapper::toDto)
                .toList();

        return new OrderResponseDto(
                order.getId(),
                order.getOrderDate(),
                order.getTotalPrice(),
                order.getDeliveryAddress(),
                order.getContactPhone(),
                order.getDeliveryMethod(),
                order.getDeliveryCompany(), // ✅ добавлено
                order.getTrackingLink(),   // ✅ добавлено
                order.getStatus(),
                order.getUser().getEmail(),
                items
        );
    }

    public void updateEntity(Order order, OrderRequestDto dto, User user) {
        order.setUser(user);
        order.setOrderDate(dto.orderDate());
        order.setTotalPrice(dto.totalPrice());
        order.setDeliveryAddress(dto.deliveryAddress());
        order.setContactPhone(dto.contactPhone());
        order.setDeliveryMethod(dto.deliveryMethod());
        order.setDeliveryCompany(dto.deliveryCompany());
        order.setTrackingLink(dto.trackingLink());
    }

}
