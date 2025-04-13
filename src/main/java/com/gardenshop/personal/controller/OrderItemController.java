package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.order.OrderItemRequestDto;
import com.gardenshop.personal.dto.order.OrderItemResponseDto;
import com.gardenshop.personal.service.interfaces.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-items")
@RequiredArgsConstructor
public class OrderItemController {

    private final OrderItemService orderItemService;

    @PostMapping
    public OrderItemResponseDto addOrderItem(@RequestBody OrderItemRequestDto requestDto) {
        return orderItemService.addOrderItem(requestDto);
    }

    @GetMapping("/{orderId}")
    public List<OrderItemResponseDto> getItemsByOrderId(@PathVariable Long orderId) {
        return orderItemService.getItemsByOrderId(orderId);
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}
