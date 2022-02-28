package com.study.springbootstudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
@Controller
public class HomeController {
    @GetMapping(value = "/ajaxHome")
    public String home() {
        return "ajaxHome";
    }

}
