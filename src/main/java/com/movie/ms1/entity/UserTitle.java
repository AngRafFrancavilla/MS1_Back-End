package com.movie.ms1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_titles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTitle {

    @EmbeddedId
    private UserTitleId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("titleId")
    @JoinColumn(name = "title_id")
    private Title title;

    private LocalDateTime addedAt = LocalDateTime.now();
}
