package com.movie.ms1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;

    @Column(nullable = false, precision = 2, scale = 1)
    private BigDecimal rating;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Boolean verified = false;

    private Boolean approved = false;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt;
}

