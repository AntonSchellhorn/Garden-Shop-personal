package com.gardenshop.personal.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderResponseDto(Long id, LocalDateTime orderDate, BigDecimal totalPrice, Long userId) {}
