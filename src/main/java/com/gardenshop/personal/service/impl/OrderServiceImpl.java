package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.dto.order.OrderRequestDto;
import com.gardenshop.personal.dto.order.OrderResponseDto;
import com.gardenshop.personal.exception.UserNotFoundException;
import com.gardenshop.personal.mapper.OrderMapper;
import com.gardenshop.personal.model.cart.Cart;
import com.gardenshop.personal.model.cart.CartItem;
import com.gardenshop.personal.model.order.Order;
import com.gardenshop.personal.model.order.OrderItem;
import com.gardenshop.personal.model.order.OrderStatus;
import com.gardenshop.personal.model.user.User;
import com.gardenshop.personal.repository.CartRepository;
import com.gardenshop.personal.repository.OrderRepository;
import com.gardenshop.personal.repository.UserRepository;
import com.gardenshop.personal.service.interfaces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        User user = userRepository.findById(orderRequestDto.userId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Cart not found"));

        Order order = orderMapper.toEntity(orderRequestDto, user);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem cartItem : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice());
            orderItems.add(orderItem);
        }

        order.setOrderItems(orderItems);
        order.setStatus(OrderStatus.AWAITING_PAYMENT);

        order = orderRepository.save(order);
        cartRepository.delete(cart);

        return orderMapper.toDto(order);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderResponseDto> getOrdersByUserId(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return orderRepository.findAllByUserId(userId).stream()
                .map(orderMapper::toDto)
                .toList();
    }

    @Override
    public OrderResponseDto updateOrder(Long orderId, OrderRequestDto dto) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Заказ не найден"));

        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new UserNotFoundException("Пользователь не найден"));

        orderMapper.updateEntity(order, dto, user);
        Order updated = orderRepository.save(order);

        return orderMapper.toDto(updated);
    }
}
