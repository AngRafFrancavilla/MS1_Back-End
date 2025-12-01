package com.movie.ms1.service;

import com.movie.ms1.dto.TitleDTO;
import org.springframework.data.domain.Page;
import java.time.LocalDate;

public interface TitleService {

    TitleDTO createTitle(TitleDTO dto);

    TitleDTO getTitleById(Long id);

    Page<TitleDTO> getAllTitles(int page, int size);

    void deleteTitle(Long id);

    TitleDTO updateTitle(Long id, TitleDTO dto);

    Page<TitleDTO> searchByName(String name, int page, int size);

    Page<TitleDTO> searchByReleaseDate(LocalDate start, LocalDate end, int page, int size);

    Page<TitleDTO> searchByGenre(String genre, int page, int size);
}
