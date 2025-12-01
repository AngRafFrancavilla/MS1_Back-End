package com.movie.ms1.service;

import com.movie.ms1.dto.ReviewDTO;
import com.movie.ms1.dto.ReviewForRatingDTO;
import com.movie.ms1.entity.Review;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;

public interface ReviewService {

    Review createReview(Long userId, Long titleId, BigDecimal rating, String content);

    Review approveReview(Long reviewId);

    Review verifyReview(Long reviewId);

    Page<ReviewDTO> getReviewsForTitle(Long titleId, int page, int size);

    List<ReviewForRatingDTO> getAllApprovedReviewsForRating();
}
