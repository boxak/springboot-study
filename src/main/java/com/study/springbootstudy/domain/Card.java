package com.study.springbootstudy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.YearMonth;

@Getter
@Setter
@ToString
public class Card {
    private String no;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private YearMonth validMonth;
}
