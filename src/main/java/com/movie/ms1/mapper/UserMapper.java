package com.movie.ms1.mapper;

import com.movie.ms1.dto.UserDTO;
import com.movie.ms1.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User entity);
    User toEntity(UserDTO dto);
}

