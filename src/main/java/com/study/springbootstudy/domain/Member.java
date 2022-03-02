package com.study.springbootstudy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
public class Member {

    @NotBlank
    private String userId;
    @NotBlank
    private String password;

    @NotBlank
    @Size(max = 3)
    private String userName;

    @Valid
    private Address address;

    @Past
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Valid
    private List<Card> cardList;

    @Email
    private String email;
    private String gender;
}
