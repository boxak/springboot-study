package com.study.springbootstudy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@Slf4j
@RestController
@RequestMapping("/greetings")
@RequiredArgsConstructor
public class GreetingController {

    private final MessageSource messageSource;

    @GetMapping(path = "/welcome", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> welcome() {
        String[] args = {"홍길동"};

        String message = messageSource.getMessage("welcome.message", args, Locale.KOREAN);
        log.info("Welcome message : " + message);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
