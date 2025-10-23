package com.movie.ms1.repository;

import com.movie.ms1.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByTitleIdOrderByVerifiedDescCreatedAtDesc(Long titleId, Pageable pageable);
    List<Review> findByApprovedTrue();
}
