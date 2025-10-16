package com.movie.ms1.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class TitleDTO {
    private Long id;
    private String name;
    private String description;
    private String genre;
    private LocalDate releaseDate;
}
