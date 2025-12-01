package com.movie.ms1.mapper;

import com.movie.ms1.dto.UsernameANDEmailDTO;
import com.movie.ms1.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-28T13:14:57+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class UsernameAndEmailMapperImpl implements UsernameAndEmailMapper {

    @Override
    public UsernameANDEmailDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UsernameANDEmailDTO usernameANDEmailDTO = new UsernameANDEmailDTO();

        usernameANDEmailDTO.setUsername( entity.getUsername() );
        usernameANDEmailDTO.setEmail( entity.getEmail() );

        return usernameANDEmailDTO;
    }

    @Override
    public User toEntity(UsernameANDEmailDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( dto.getUsername() );
        user.email( dto.getEmail() );

        return user.build();
    }
}
