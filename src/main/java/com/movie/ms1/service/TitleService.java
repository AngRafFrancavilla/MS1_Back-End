package com.movie.ms1.service;

import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.entity.Title;
import com.movie.ms1.repository.ReviewRepository;
import com.movie.ms1.repository.TitleRepository;
import com.movie.ms1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.movie.ms1.mapper.TitleMapper;
import com.movie.ms1.mapper.ReviewMapper;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class TitleService {

    private final TitleRepository titleRepository;
    private final TitleMapper titleMapper;

    public TitleDTO createTitle(TitleDTO dto) {
        Title title = titleMapper.toEntity(dto);
        Title saved = titleRepository.save(title);
        return titleMapper.toDto(saved);
    }

    public TitleDTO getTitleById(Long id) {
        Title title = titleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Titolo non trovato"));
        return titleMapper.toDto(title);
    }

    public Page<TitleDTO> getAllTitles(int page, int size) {
        return titleRepository.findAll(PageRequest.of(page, size))
                .map(titleMapper::toDto);
    }

    public void deleteTitle(Long id) {
        Title title = titleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Titolo non trovato"));
        titleRepository.delete(title);
    }
    public TitleDTO updateTitle(Long id, TitleDTO dto) {
        Title existing = titleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Titolo non trovato"));

        existing.setName(dto.getName());
        existing.setDescription(dto.getDescription());
        existing.setReleaseDate(dto.getReleaseDate());
        existing.setGenre(dto.getGenre());

        Title updated = titleRepository.save(existing);
        return titleMapper.toDto(updated);
    }

    public Page<TitleDTO> searchByName(String name, int page, int size) {
        return titleRepository.findByNameContainingIgnoreCase(name, PageRequest.of(page, size))
                .map(titleMapper::toDto);
    }

    public Page<TitleDTO> searchByReleaseDate(LocalDate start, LocalDate end, int page, int size) {
        return titleRepository.findByReleaseDateBetween(start, end, PageRequest.of(page, size))
                .map(titleMapper::toDto);
    }

    public Page<TitleDTO> searchByGenre(String genre, int page, int size) {
        return titleRepository.findByGenreIgnoreCase(genre, PageRequest.of(page, size))
                .map(titleMapper::toDto);
    }

}
