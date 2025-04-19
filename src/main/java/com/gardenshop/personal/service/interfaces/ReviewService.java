package com.gardenshop.personal.service;

import com.gardenshop.personal.dto.review.ReviewRequestDto;
import com.gardenshop.personal.dto.review.ReviewResponseDto;

import java.util.List;

public interface ReviewService {

    ReviewResponseDto createReview(ReviewRequestDto requestDto);

    List<ReviewResponseDto> getReviewsByProductId(Long productId);

    void deleteReview(Long id);
}
