package com.movie.ms1.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTitleId implements Serializable {
    private Long userId;
    private Long titleId;
}
