package com.movie.ms1.repository;

import com.movie.ms1.entity.UserTitle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTitleRepository extends JpaRepository<UserTitle, Long> {
    Page<UserTitle> findByUserId(Long userId, Pageable pageable);
}
