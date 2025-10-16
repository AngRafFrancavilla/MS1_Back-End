package com.movie.ms1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDTO {
    private Long id;
    private String username;
    private String titleName;
    private String content;
    private BigDecimal rating;
    private Boolean verified;
    private Boolean approved;
    private LocalDateTime createdAt;
}

