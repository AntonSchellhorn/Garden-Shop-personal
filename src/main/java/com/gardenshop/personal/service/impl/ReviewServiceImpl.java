package com.gardenshop.personal.service.impl;

import com.gardenshop.personal.dto.review.ReviewRequestDto;
import com.gardenshop.personal.dto.review.ReviewResponseDto;
import com.gardenshop.personal.exception.ReviewNotFoundException;
import com.gardenshop.personal.mapper.ReviewMapper;
import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.model.review.Review;
import com.gardenshop.personal.model.user.User;
import com.gardenshop.personal.repository.ProductRepository;
import com.gardenshop.personal.repository.ReviewRepository;
import com.gardenshop.personal.repository.UserRepository;
import com.gardenshop.personal.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public ReviewResponseDto createReview(ReviewRequestDto requestDto) {
        User user = userRepository.findById(requestDto.userId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));
        Product product = productRepository.findById(requestDto.productId())
                .orElseThrow(() -> new ReviewNotFoundException("Отзыв с id " + requestDto.productId() + " не найден"));
        Review review = reviewMapper.toEntity(requestDto, user, product);
        return reviewMapper.toDto(reviewRepository.save(review));
    }

    @Override
    public List<ReviewResponseDto> getReviewsByProductId(Long productId) {
        return reviewRepository.findAllByProductId(productId)
                .stream()
                .map(reviewMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }
}
