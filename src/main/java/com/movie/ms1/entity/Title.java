package com.movie.ms1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "titles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Title {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String genre;

    private LocalDate releaseDate;

    private String type;

    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "title", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UserTitle> userTitles = new HashSet<>();
}
