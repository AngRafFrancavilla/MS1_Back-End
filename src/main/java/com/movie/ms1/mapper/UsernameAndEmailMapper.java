package com.movie.ms1.mapper;

import com.movie.ms1.dto.UsernameANDEmailDTO;
import com.movie.ms1.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UsernameAndEmailMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UsernameANDEmailDTO toDto(User entity);
    User toEntity(UsernameANDEmailDTO dto);
}


