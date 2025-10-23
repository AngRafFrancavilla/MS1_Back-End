package com.movie.ms1.controller;


import com.movie.ms1.dto.TitleDTO;
import com.movie.ms1.mapper.TitleMapper;
import com.movie.ms1.service.UserTitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/titles")
@RequiredArgsConstructor
public class UserTitleController {
    private final UserTitleService userTitleService;
    private final TitleMapper titleMapper;

    @PostMapping("/{titleId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Void> addToWatchlist(@PathVariable Long userId, @PathVariable Long titleId) {
        userTitleService.addTitleToUser(userId, titleId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<Page<TitleDTO>> getUserTitles(@PathVariable Long userId,
                                                        @RequestParam(defaultValue = "0") int page,
                                                        @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(userTitleService.getUserTitles(userId, page, size, titleMapper));
    }
}
