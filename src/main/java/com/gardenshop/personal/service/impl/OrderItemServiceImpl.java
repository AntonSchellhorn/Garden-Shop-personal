package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.dto.order.OrderItemRequestDto;
import com.gardenshop.personal.dto.order.OrderItemResponseDto;
import com.gardenshop.personal.mapper.OrderItemMapper;
import com.gardenshop.personal.model.order.Order;
import com.gardenshop.personal.model.order.OrderItem;
import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.repository.OrderItemRepository;
import com.gardenshop.personal.repository.OrderRepository;
import com.gardenshop.personal.repository.ProductRepository;
import com.gardenshop.personal.service.interfaces.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final OrderItemMapper orderItemMapper;

    @Override
    public OrderItemResponseDto addOrderItem(OrderItemRequestDto requestDto) {
        Order order = orderRepository.findById(requestDto.orderId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        Product product = productRepository.findById(requestDto.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(requestDto.quantity());

        orderItemRepository.save(item);
        return orderItemMapper.toDto(item);
    }

    @Override
    public List<OrderItemResponseDto> getItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId)
                .stream()
                .map(orderItemMapper::toDto)
                .toList();
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
