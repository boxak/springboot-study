package com.study.springbootstudy.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class Address {

    @NotBlank
    private String postCode;
    @NotBlank
    private String location;

}
