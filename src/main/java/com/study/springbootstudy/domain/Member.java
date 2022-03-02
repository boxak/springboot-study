package com.study.springbootstudy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class Member {
    private String userId;
    private String password;
    private int coin;
    private Address address;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private List<Card> cardList;
}
