package com.movie.ms1.mapper;

import com.movie.ms1.dto.ReviewDTO;
import com.movie.ms1.entity.Review;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-23T19:35:03+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public ReviewDTO toDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewDTO.ReviewDTOBuilder reviewDTO = ReviewDTO.builder();

        reviewDTO.id( review.getId() );
        reviewDTO.content( review.getContent() );
        reviewDTO.rating( review.getRating() );
        reviewDTO.verified( review.getVerified() );
        reviewDTO.approved( review.getApproved() );
        reviewDTO.createdAt( review.getCreatedAt() );

        return reviewDTO.build();
    }

    @Override
    public Review toEntity(ReviewDTO reviewDTO) {
        if ( reviewDTO == null ) {
            return null;
        }

        Review.ReviewBuilder review = Review.builder();

        review.id( reviewDTO.getId() );
        review.rating( reviewDTO.getRating() );
        review.content( reviewDTO.getContent() );
        review.verified( reviewDTO.getVerified() );
        review.approved( reviewDTO.getApproved() );
        review.createdAt( reviewDTO.getCreatedAt() );

        return review.build();
    }

    @Override
    public void updateEntityFromDto(ReviewDTO dto, Review entity) {
        if ( dto == null ) {
            return;
        }

        entity.setId( dto.getId() );
        entity.setRating( dto.getRating() );
        entity.setContent( dto.getContent() );
        entity.setVerified( dto.getVerified() );
        entity.setApproved( dto.getApproved() );
        entity.setCreatedAt( dto.getCreatedAt() );
    }
}
