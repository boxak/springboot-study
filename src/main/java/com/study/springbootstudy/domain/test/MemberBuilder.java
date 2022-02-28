package com.study.springbootstudy.domain.test;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class MemberBuilder {
    private String userId;
    private String password;
    private String userName;
}
