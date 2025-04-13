package com.gardenshop.personal.controller;

import com.gardenshop.personal.dto.order.OrderItemRequestDto;
import com.gardenshop.personal.dto.order.OrderItemResponseDto;
import com.gardenshop.personal.service.interfaces.OrderItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-items")
@RequiredArgsConstructor
@Tag(name = "Элементы заказа", description = "Управление товарами внутри заказов")
public class OrderItemController {

    private final OrderItemService orderItemService;

    @Operation(summary = "Добавить товар в заказ")
    @PostMapping
    public OrderItemResponseDto addOrderItem(@RequestBody OrderItemRequestDto requestDto) {
        return orderItemService.addOrderItem(requestDto);
    }

    @Operation(summary = "Получить товары по ID заказа")
    @GetMapping("/{orderId}")
    public List<OrderItemResponseDto> getItemsByOrderId(@PathVariable Long orderId) {
        return orderItemService.getItemsByOrderId(orderId);
    }

    @Operation(summary = "Удалить товар из заказа по его ID")
    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}
