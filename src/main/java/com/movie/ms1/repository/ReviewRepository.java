package com.movie.ms1.repository;

import com.movie.ms1.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByTitleIdOrderByVerifiedDescCreateAtDesc(Long titleId, Pageable pageable);
}
