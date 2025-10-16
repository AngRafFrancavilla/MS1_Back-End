package com.movie.ms1.controller;

import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.entity.Title;
import com.movie.ms1.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/titles")
@RequiredArgsConstructor
public class TitleController {

    private final TitleService titleService;

    @GetMapping("/list")
    public Page<TitleDTO> getAllTitles(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return titleService.getAllTitles(page, size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TitleDTO> getTitleById(@PathVariable Long id) {
        TitleDTO title = titleService.getTitleById(id);
        return ResponseEntity.ok(title);
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<TitleDTO> createTitle(@RequestBody TitleDTO dto) {
        TitleDTO created = titleService.createTitle(dto);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTitle(@PathVariable Long id) {
        titleService.deleteTitle(id);
        return ResponseEntity.noContent().build();
    }

}
