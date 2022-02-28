package com.study.springbootstudy.domain.test;

import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

//@ToString, @Getter, @Setter, @EqualsAndHashCode, @RequiredArgsConstructor
@Data
public class BoardData {
    private final int boardNo;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
}
