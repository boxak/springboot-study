package com.study.springbootstudy.domain;

import lombok.Builder;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Builder
public class BoardBuilder {
    private int boardNo;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
}
