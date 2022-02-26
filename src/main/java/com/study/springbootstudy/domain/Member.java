package com.study.springbootstudy.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "userName")
public class Member {
    private String userId;
    private String password;
    private String userName;
}
