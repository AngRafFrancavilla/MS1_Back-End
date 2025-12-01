package com.movie.ms1.service;

import com.movie.ms1.dto.TitleDTO;
import org.springframework.data.domain.Page;

public interface UserTitleService {

    void addTitleToUser(Long userId, Long titleId);

    Page<TitleDTO> getUserTitles(Long userId, int page, int size);
}
