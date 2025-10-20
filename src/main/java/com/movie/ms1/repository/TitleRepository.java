package com.movie.ms1.repository;

import com.movie.ms1.entity.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;


public interface TitleRepository extends JpaRepository<Title, Long> {
    Page<Title> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Title> findByReleaseDateBetween(LocalDate start, LocalDate end, Pageable pageable);
    Page<Title> findByGenreIgnoreCase(String genre, Pageable pageable);

}
