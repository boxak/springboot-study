package com.study.springbootstudy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class Member {

    @NotBlank
    private String userId;
    private String password;

    @NotBlank
    @Size(max = 3)
    private String userName;
    private Address address;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private List<Card> cardList;

    private String email;
    private String gender;
}
