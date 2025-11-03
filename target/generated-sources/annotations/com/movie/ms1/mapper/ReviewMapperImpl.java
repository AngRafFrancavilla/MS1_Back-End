package com.movie.ms1.mapper;

import com.movie.ms1.dto.ReviewDTO;
import com.movie.ms1.entity.Review;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T17:59:41+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewDTO toDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewDTO.ReviewDTOBuilder reviewDTO = ReviewDTO.builder();

        reviewDTO.approved( review.getApproved() );
        reviewDTO.content( review.getContent() );
        reviewDTO.createdAt( review.getCreatedAt() );
        reviewDTO.id( review.getId() );
        reviewDTO.rating( review.getRating() );
        reviewDTO.verified( review.getVerified() );

        return reviewDTO.build();
    }

    @Override
    public Review toEntity(ReviewDTO reviewDTO) {
        if ( reviewDTO == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.approved( reviewDTO.getApproved() );
        review.content( reviewDTO.getContent() );
        review.createdAt( reviewDTO.getCreatedAt() );
        review.id( reviewDTO.getId() );
        review.rating( reviewDTO.getRating() );
        review.verified( reviewDTO.getVerified() );

        return review.build();
    }

    @Override
    public void updateEntityFromDto(ReviewDTO dto, Review entity) {
        if ( dto == null ) {
            return;
        }

        entity.setApproved( dto.getApproved() );
        entity.setContent( dto.getContent() );
        entity.setCreatedAt( dto.getCreatedAt() );
        entity.setId( dto.getId() );
        entity.setRating( dto.getRating() );
        entity.setVerified( dto.getVerified() );
    }
}
