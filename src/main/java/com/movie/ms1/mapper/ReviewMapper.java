package com.movie.ms1.mapper;

import com.movie.ms1.dto.ReviewDTO;
import com.movie.ms1.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO toDto(Review review);

    Review toEntity(ReviewDTO reviewDTO);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "title", ignore = true)
    void updateEntityFromDto(ReviewDTO dto, @MappingTarget Review entity);

}
