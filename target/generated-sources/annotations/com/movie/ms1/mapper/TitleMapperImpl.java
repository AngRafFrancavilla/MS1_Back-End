package com.movie.ms1.mapper;

import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.entity.Title;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T17:59:42+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.44.0.v20251023-0518, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class TitleMapperImpl implements TitleMapper {

    @Override
    public TitleDTO toDto(Title entity) {
        if ( entity == null ) {
            return null;
        }

        TitleDTO titleDTO = new TitleDTO();

        titleDTO.setDescription( entity.getDescription() );
        titleDTO.setGenre( entity.getGenre() );
        titleDTO.setId( entity.getId() );
        titleDTO.setName( entity.getName() );
        titleDTO.setReleaseDate( entity.getReleaseDate() );

        return titleDTO;
    }

    @Override
    public Title toEntity(TitleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Title.TitleBuilder title = Title.builder();

        title.description( dto.getDescription() );
        title.genre( dto.getGenre() );
        title.id( dto.getId() );
        title.name( dto.getName() );
        title.releaseDate( dto.getReleaseDate() );

        return title.build();
    }
}
