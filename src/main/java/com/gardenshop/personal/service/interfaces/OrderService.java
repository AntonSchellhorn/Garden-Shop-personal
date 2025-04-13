package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.order.OrderRequestDto;
import com.gardenshop.personal.dto.order.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);
    List<OrderResponseDto> getAllOrders();
    List<OrderResponseDto> getOrdersByUserId(Long userId);

}
