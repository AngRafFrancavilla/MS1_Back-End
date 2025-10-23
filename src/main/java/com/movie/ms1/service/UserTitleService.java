package com.movie.ms1.service;

import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.entity.Title;
import com.movie.ms1.entity.User;
import com.movie.ms1.entity.UserTitle;
import com.movie.ms1.mapper.TitleMapper;
import com.movie.ms1.repository.TitleRepository;
import com.movie.ms1.repository.UserRepository;
import com.movie.ms1.repository.UserTitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTitleService {
    private final UserRepository userRepository;
    private final TitleRepository titleRepository;
    private final UserTitleRepository userTitleRepository;

    public void addTitleToUser(Long userId, Long titleId) {
        User user = userRepository.findById(userId).orElseThrow();
        Title title = titleRepository.findById(titleId).orElseThrow();

        UserTitle userTitle = UserTitle.builder()
                .user(user)
                .title(title)
                .build();

        userTitleRepository.save(userTitle);
    }

    public Page<TitleDTO> getUserTitles(Long userId, int page, int size, TitleMapper mapper) {
        return userTitleRepository.findByUserId(userId, PageRequest.of(page, size))
                .map(userTitle -> mapper.toDto(userTitle.getTitle()));
    }
}
