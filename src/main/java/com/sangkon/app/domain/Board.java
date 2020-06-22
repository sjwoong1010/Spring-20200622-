package com.sangkon.app.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@ToString(exclude = "user")
public class Board {
    @Id
    @GeneratedValue
    private Long idx;

    @NotEmpty(message = "Title is not Empty")
    private String title;

    @NotEmpty(message = "SubTitle is not Empty")
    private String subTitle;
    private String content;

    @Enumerated(EnumType.STRING)
    private BoardType boardType;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

}
