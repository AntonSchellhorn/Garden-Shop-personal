package com.gardenshop.personal.mapper;

import com.gardenshop.personal.dto.review.ReviewRequestDto;
import com.gardenshop.personal.dto.review.ReviewResponseDto;
import com.gardenshop.personal.model.product.Product;
import com.gardenshop.personal.model.review.Review;
import com.gardenshop.personal.model.user.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReviewMapper {

    public Review toEntity(ReviewRequestDto requestDto, User user, Product product) {
        Review review = new Review();
        review.setUser(user);
        review.setProduct(product);
        review.setRating(requestDto.rating());
        review.setComment(requestDto.comment());
        review.setCreatedAt(LocalDateTime.now()); // При создании отзыва ставим текущую дату
        return review;
    }

    public ReviewResponseDto toDto(Review review) {
        return new ReviewResponseDto(
                review.getId(),
                review.getUser().getEmail(),
                review.getProduct().getName(),
                review.getRating(),
                review.getComment(),
                review.getCreatedAt()
        );
    }
}
