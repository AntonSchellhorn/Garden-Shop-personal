package com.gardenshop.personal.dto.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderRequestDto(LocalDateTime orderDate, BigDecimal totalPrice) {}
