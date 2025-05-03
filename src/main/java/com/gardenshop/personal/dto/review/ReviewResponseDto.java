package com.gardenshop.personal.dto.review;

import java.time.LocalDateTime;

public record ReviewResponseDto(
        Long id,
        String userEmail,
        String productName,
        int rating,
        String comment,
        LocalDateTime createdAt
) {}
