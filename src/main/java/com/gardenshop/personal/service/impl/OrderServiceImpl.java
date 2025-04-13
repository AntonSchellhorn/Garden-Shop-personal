package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.dto.order.OrderRequestDto;
import com.gardenshop.personal.dto.order.OrderResponseDto;
import com.gardenshop.personal.mapper.OrderMapper;
import com.gardenshop.personal.model.order.Order;
import com.gardenshop.personal.model.user.User;
import com.gardenshop.personal.repository.OrderRepository;
import com.gardenshop.personal.repository.UserRepository;
import com.gardenshop.personal.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        // 🔧 Временно подставляем пользователя с ID = 1
        User user = userRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Order order = orderMapper.toEntity(orderRequestDto, user);
        order = orderRepository.save(order);

        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }
}
