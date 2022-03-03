package com.study.springbootstudy.controller;

import com.study.springbootstudy.domain.Address;
import com.study.springbootstudy.domain.Card;
import com.study.springbootstudy.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/register04")
    public List<Member> register04() {
        log.info("register04");

        Member member1 = new Member();

        member1.setUserId("userId1");
        member1.setPassword("1234");
        member1.setDateOfBirth(LocalDate.of(1995,2,4));

        Member member2 = new Member();

        member2.setUserId("userId2");
        member2.setPassword("1234");
        member2.setDateOfBirth(LocalDate.of(1996,3,4));

        List<Member> list = new ArrayList<>();
        list.add(member1);
        list.add(member2);

        return list;
    }

    @GetMapping("/register05")
    public Map<String, Member> register05() {
        log.info("register05");

        Member member1 = new Member();

        member1.setUserId("userId1");
        member1.setPassword("1234");
        member1.setDateOfBirth(LocalDate.of(1995,2,4));

        Member member2 = new Member();

        member2.setUserId("userId2");
        member2.setPassword("1234");
        member2.setDateOfBirth(LocalDate.of(1996,3,4));

        Map<String, Member> map = new HashMap<>();

        map.put("key1", member1);
        map.put("key2", member2);

        return map;
    }

    @GetMapping("/register06")
    public ResponseEntity<Void> register06() {
        log.info("register06");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/register07")
    public ResponseEntity<String> register07() {
        log.info("register07");

        return new ResponseEntity<>("HELLO", HttpStatus.OK);
    }

    @GetMapping("/register08")
    public ResponseEntity<Member> register08() {
        log.info("register08");

        Member member1 = new Member();

        member1.setUserId("userId1");
        member1.setPassword("1234");
        member1.setDateOfBirth(LocalDate.of(1995,2,4));

        return new ResponseEntity<>(member1, HttpStatus.OK);
    }

    @GetMapping("/register09")
    public ResponseEntity<List<Member>> register09() {
        log.info("register09");

        Member member1 = new Member();

        member1.setUserId("userId1");
        member1.setPassword("1234");
        member1.setDateOfBirth(LocalDate.of(1995,2,4));

        Member member2 = new Member();

        member2.setUserId("userId2");
        member2.setPassword("1234");
        member2.setDateOfBirth(LocalDate.of(1996,3,4));

        List<Member> list = new ArrayList<>();
        list.add(member1);
        list.add(member2);

        return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
    }

    @GetMapping("/register10")
    public ResponseEntity<Map<String, Member>> register10() {
        log.info("register10");

        Map<String, Member> map = new HashMap<>();

        Member member1 = new Member();

        member1.setUserId("userId1");
        member1.setPassword("1234");
        member1.setDateOfBirth(LocalDate.of(1995,2,4));

        Member member2 = new Member();

        member2.setUserId("userId2");
        member2.setPassword("1234");
        member2.setDateOfBirth(LocalDate.of(1996,3,4));

        map.put("key1", member1);
        map.put("key2", member2);

        return new ResponseEntity<Map<String, Member>>(map, HttpStatus.OK);
    }

    @GetMapping("/register1101")
    public ResponseEntity<byte[]> register1101() throws Exception {
        log.info("register1101");

        ResponseEntity<byte[]> entity = null;

        try {
            HttpHeaders headers = new HttpHeaders();

            File file = new File("C:\\Users\\Administrator\\Pictures\\sample.jpg");
            headers.setContentType(MediaType.IMAGE_JPEG);
            entity = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/register1102")
    public ResponseEntity<byte[]> register1102() throws Exception {
        log.info("register1102");

        ResponseEntity<byte[]> entity = null;

        try {
            HttpHeaders headers = new HttpHeaders();

            File file = new File("C:\\Users\\Administrator\\Pictures\\Pictures.zip");
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.add("Content-Disposition", "attachment; filename=\"" + new String("Pictures.zip".getBytes(StandardCharsets.UTF_8),
                    "ISO-8859-1")+"\"");
            entity = new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @GetMapping("/register/{userId}")
    public ResponseEntity<String> register01(@PathVariable("userId") String userId) {
        log.info("register01");
        log.info("userId = " + userId);
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/register/{userId}/{password}")
    public ResponseEntity<String> register02(@PathVariable String userId,
                                             @PathVariable String password) {
        log.info("register02");

        log.info("userId = " + userId);
        log.info("password = " + password);

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }

    @PostMapping("/register03")
    public ResponseEntity<String> register03(String userId) {
        log.info("register03");
        log.info("userId = " + userId);
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/register04")
    public ResponseEntity<String> register04(@RequestBody List<Member> memberList) {
        log.info("register04");
        for (Member member : memberList) {
            log.info("userId = " + member.getUserId());
            log.info("password = " + member.getPassword());
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/register05")
    public ResponseEntity<String> register05(@RequestBody Member member) {
        log.info("register05");

        log.info("userId = " + member.getUserId());
        log.info("password = " + member.getPassword());

        Address address = member.getAddress();

        if (address != null) {
            log.info("address.getPostCode() = " + address.getPostCode());
            log.info("address.getLocation() = " + address.getLocation());
        } else {
            log.info("address == null");
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping("/register06")
    public ResponseEntity<String> register06(@RequestBody Member member) {
        log.info("register06");

        log.info("userId = " + member.getUserId());
        log.info("password = " + member.getPassword());

        List<Card> cardList = member.getCardList();

        if (cardList != null) {
            log.info("cardList.size() = " + cardList.size());
            for (int i = 0;i< cardList.size();i++) {
                Card card = cardList.get(i);
                log.info("card.getNo() = " + card.getNo());
                log.info("card.getValidMonth() = " + card.getValidMonth());
            }
        } else {
            log.info("cardList==null");
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PostMapping(path = "/upload", produces = "text/plain;charset=UTF-8")
    public ResponseEntity<String> upload(MultipartFile file) throws Exception {
        String originalFilename = file.getOriginalFilename();

        log.info("originalName : " + originalFilename);

        ResponseEntity<String> entity = new ResponseEntity<>("UPLOAD SUCCESS " + originalFilename, HttpStatus.OK);
        return entity;
    }

    @PostMapping(path = "/users", produces = "text/plain;charset=utf-8")
    public ResponseEntity<String> register(@Validated @RequestBody Member member,
                                           BindingResult result) {
        log.info("register");

        if (result.hasErrors()) {

            List<ObjectError> allErrors = result.getAllErrors();
            List<ObjectError> globalErrors = result.getGlobalErrors();
            List<FieldError> fieldErrors = result.getFieldErrors();

            log.info("allErrors.size() = " + allErrors.size());
            log.info("globalErrors.size() = " + globalErrors.size());
            log.info("fieldErrors.size() = " + fieldErrors.size());

            for (ObjectError objectError : allErrors) {
                log.info("allError = " + objectError);
            }

            for (ObjectError objectError : globalErrors) {
                log.info("allError = " + objectError);
            }

            for (FieldError fieldError : fieldErrors) {
                log.info("allError = " + fieldError);
                log.info("fieldError.getDefaultMessage() = " + fieldError.getDefaultMessage());
            }

            ResponseEntity<String> entity = new ResponseEntity<>(result.toString(), HttpStatus.BAD_REQUEST);
            return entity;
        }

        log.info("member.getUserId() = " + member.getUserId());
        log.info("member.getPassword() = " + member.getPassword());
        log.info("member.getUserName() = " + member.getUserName());
        log.info("member.getEmail() = " + member.getEmail());
        log.info("member.getGender() = " + member.getGender());

        Address address = member.getAddress();
//
        if (address != null) {
            log.info("address != null address.getPostCode() = " + address.getPostCode());
            log.info("address != null address.getLocation() = " + address.getLocation());
        } else {
            log.info("address == null");
        }

        List<Card> cardList = member.getCardList();

        if (cardList != null) {
            log.info("cardList != null and ==" + cardList.size());

            for (Card card : cardList) {
                log.info("card.getNo() = " + card.getNo());
                log.info("card.getValidMonth() = " + card.getValidMonth());
            }
        } else {
            log.info("cardList == null");
        }

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }
}
