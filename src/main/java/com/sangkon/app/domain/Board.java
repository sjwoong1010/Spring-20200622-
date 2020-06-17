package com.sangkon.app.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long idx;

    private String title;
    private String subTitle;
    private String content;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
