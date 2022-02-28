package com.study.springbootstudy.controller;

import com.study.springbootstudy.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Slf4j
@RestController
public class MemberController {

    @GetMapping("/register01")
    public void register01() {
        log.info("register01");
    }

    @GetMapping("/register02")
    public String register02() {
        log.info("register02");
        return "HELLO";
    }

    @GetMapping("/register03")
    public Member register03() {
        log.info("register03");
        Member member = new Member();

        member.setUserId("userId1");
        member.setPassword("1234");
        member.setDateOfBirth(LocalDate.of(1995,2,4));

        return member;
    }

}
