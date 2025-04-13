package com.gardenshop.personal.service.interfaces;

import com.gardenshop.personal.dto.order.OrderItemRequestDto;
import com.gardenshop.personal.dto.order.OrderItemResponseDto;
import com.gardenshop.personal.dto.user.LoginRequestDto;

import java.util.List;

public interface AuthService {
    String login(LoginRequestDto request);

    interface OrderItemService {

        OrderItemResponseDto addOrderItem(OrderItemRequestDto requestDto);

        List<OrderItemResponseDto> getItemsByOrderId(Long orderId);

        void deleteOrderItem(Long orderItemId);
    }
}
