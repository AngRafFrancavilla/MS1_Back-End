package com.movie.ms1.controller;

import com.movie.ms1.dto.ReviewDTO;
import com.movie.ms1.dto.ReviewForRatingDTO;
import com.movie.ms1.entity.Review;
import com.movie.ms1.mapper.ReviewMapper;
import com.movie.ms1.repository.UserRepository;
import com.movie.ms1.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;

    //per ricavare userId dall'username
    private Long getUserIdFromPrincipal(UserDetails userDetails) {
        String username = userDetails.getUsername();
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found: " + username))
                .getId();
    }

    @PostMapping("/{titleId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReviewDTO> createReview(@PathVariable Long titleId,
                                                  @RequestBody ReviewDTO dto,
                                                  @AuthenticationPrincipal UserDetails userDetails) {
        Review review = reviewService.createReview(
                getUserIdFromPrincipal(userDetails),
                titleId,
                dto.getRating(),
                dto.getContent()
        );
        return ResponseEntity.ok(reviewMapper.toDto(review));
    }

    @GetMapping("/title/{titleId}")
    public ResponseEntity<Page<ReviewDTO>> getReviews(@PathVariable Long titleId,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Page<ReviewDTO> reviews = reviewService.getReviewsForTitle(titleId, page, size);
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/{reviewId}/approve")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ReviewDTO> approveReview(@PathVariable Long reviewId) {
        Review review = reviewService.approveReview(reviewId);
        return ResponseEntity.ok(reviewMapper.toDto(review));
    }

    @PutMapping("/{reviewId}/verify")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ReviewDTO> verifyReview(@PathVariable Long reviewId) {
        Review review = reviewService.verifyReview(reviewId);
        return ResponseEntity.ok(reviewMapper.toDto(review));
    }

    @GetMapping("/for-rating")
    public List<ReviewForRatingDTO> getAllApprovedReviewsForRating() {
        return reviewService.getAllApprovedReviewsForRating();
    }



}
