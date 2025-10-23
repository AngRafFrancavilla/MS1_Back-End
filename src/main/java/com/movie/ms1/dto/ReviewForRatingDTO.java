package com.movie.ms1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewForRatingDTO {
    private Long titleId;
    private BigDecimal rating;
    private Boolean approved;
}
