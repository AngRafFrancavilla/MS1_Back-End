package com.movie.ms1.service.impl;

import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.entity.Title;
import com.movie.ms1.entity.User;
import com.movie.ms1.entity.UserTitle;
import com.movie.ms1.entity.UserTitleId;
import com.movie.ms1.mapper.TitleMapper;
import com.movie.ms1.repository.TitleRepository;
import com.movie.ms1.repository.UserRepository;
import com.movie.ms1.repository.UserTitleRepository;
import com.movie.ms1.service.UserTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserTitleServiceImpl implements UserTitleService {
    private final UserRepository userRepository;
    private final TitleRepository titleRepository;
    private final UserTitleRepository userTitleRepository;
    private final TitleMapper titleMapper;

    public void addTitleToUser(Long userId, Long titleId) {
        User user = userRepository.findById(userId).orElseThrow();
        Title title = titleRepository.findById(titleId).orElseThrow();

        if (userTitleRepository.existsByUserIdAndTitleId(userId, titleId)) {
            throw new IllegalStateException("Titolo già presente nella bacheca");
        }

        UserTitleId id = new UserTitleId(userId, titleId);
        UserTitle userTitle = UserTitle.builder()
                .id(id)
                .user(user)
                .title(title)
                .build();

        userTitleRepository.save(userTitle);
    }

    @Override
    public Page<TitleDTO> getUserTitles(Long userId, int page, int size) {
        return userTitleRepository.findByUserId(userId, PageRequest.of(page, size))
                .map(userTitle -> titleMapper.toDto(userTitle.getTitle()));
    }

}
