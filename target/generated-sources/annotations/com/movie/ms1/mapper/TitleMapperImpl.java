package com.movie.ms1.mapper;

import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.entity.Title;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-16T16:14:26+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class TitleMapperImpl implements TitleMapper {

    @Override
    public TitleDTO toDto(Title entity) {
        if ( entity == null ) {
            return null;
        }

        TitleDTO titleDTO = new TitleDTO();

        titleDTO.setId( entity.getId() );
        titleDTO.setName( entity.getName() );
        titleDTO.setDescription( entity.getDescription() );
        titleDTO.setGenre( entity.getGenre() );
        titleDTO.setReleaseDate( entity.getReleaseDate() );

        return titleDTO;
    }

    @Override
    public Title toEntity(TitleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Title.TitleBuilder title = Title.builder();

        title.id( dto.getId() );
        title.name( dto.getName() );
        title.description( dto.getDescription() );
        title.genre( dto.getGenre() );
        title.releaseDate( dto.getReleaseDate() );

        return title.build();
    }
}
