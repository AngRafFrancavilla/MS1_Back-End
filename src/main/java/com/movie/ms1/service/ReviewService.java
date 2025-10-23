package com.movie.ms1.service;

import com.movie.ms1.dto.ReviewDTO;
import com.movie.ms1.dto.ReviewForRatingDTO;
import com.movie.ms1.entity.Review;
import com.movie.ms1.entity.Title;
import com.movie.ms1.entity.User;
import com.movie.ms1.mapper.ReviewMapper;
import com.movie.ms1.repository.ReviewRepository;
import com.movie.ms1.repository.TitleRepository;
import com.movie.ms1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final TitleRepository titleRepository;
    private final ReviewMapper reviewMapper;

    public Review createReview(Long userId, Long titleId, BigDecimal rating, String content) {
        User user = userRepository.findById(userId).orElseThrow();
        Title title = titleRepository.findById(titleId).orElseThrow();

        Review review = Review.builder()
                .user(user)
                .title(title)
                .rating(rating)
                .content(content)
                .approved(false)
                .verified(false)
                .build();

        return reviewRepository.save(review);
    }

    public Review approveReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow();
        review.setApproved(true);
        return reviewRepository.save(review);
    }

    public Review verifyReview(Long reviewId) {
        Review review = reviewRepository.findById(reviewId).orElseThrow();
        if (!review.getApproved()) {
            throw new IllegalStateException("Deve essere prima approvata");
        }
        review.setVerified(true);
        return reviewRepository.save(review);
    }


    public Page<ReviewDTO> getReviewsForTitle(Long titleId, int page, int size) {
        return reviewRepository.findByTitleIdOrderByVerifiedDescCreatedAtDesc(titleId, PageRequest.of(page, size))
                .map(reviewMapper::toDto);
    }

    public List<ReviewForRatingDTO> getAllApprovedReviewsForRating() {
        List<Review> reviews = reviewRepository.findByApprovedTrue();
        return reviews.stream()
                .map(r -> ReviewForRatingDTO.builder()
                        .titleId(r.getTitle().getId())
                        .rating(r.getRating())
                        .approved(r.getApproved())
                        .build())
                .collect(Collectors.toList());
    }


}
