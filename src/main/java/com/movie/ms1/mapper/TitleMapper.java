package com.movie.ms1.mapper;

import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.entity.Title;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TitleMapper {
    TitleMapper INSTANCE = Mappers.getMapper(TitleMapper.class);

    TitleDTO toDto(Title entity);
    Title toEntity(TitleDTO dto);
}
