package com.movie.ms1.service;

import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.entity.Title;
import com.movie.ms1.repository.TitleRepository;
import com.movie.ms1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.movie.ms1.mapper.TitleMapper;


@Service
@RequiredArgsConstructor
public class TitleService {

    private final TitleRepository titleRepository;
    private final UserRepository userRepository;
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

}
