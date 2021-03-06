package com.study.springbootstudy.controller;

import com.study.springbootstudy.domain.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {
    @GetMapping
    public ResponseEntity<List<Board>> list() {
        log.info("list");

        List<Board> boardList = new ArrayList<>();

        Board board = new Board();

        board.setBoardNo(1);
        board.setTitle("향수");
        board.setContent("넓은 벌 동쪽 끝으로");
        board.setWriter("hongkd");
        board.setRegDate(LocalDateTime.now());

        boardList.add(board);

        board = new Board();

        board.setBoardNo(2);
        board.setTitle("첫 마음");
        board.setContent("날마다 새로우며 깊어지고 넓어진다");
        board.setWriter("hongkd");
        board.setRegDate(LocalDateTime.now());

        boardList.add(board);

        ResponseEntity<List<Board>> entity = new ResponseEntity<>(boardList, HttpStatus.OK);

        return entity;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody Board board) {
        log.info("register");

        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @GetMapping("/{boardNo}")
    public ResponseEntity<Board> read(@PathVariable("boardNo") int boardNo) {
        log.info("read");

        Board board = new Board();
        board.setBoardNo(1);
        board.setTitle("향수");
        board.setContent("넓은 벌 동쪽 끝으로");
        board.setWriter("hongkd");
        board.setRegDate(LocalDateTime.now());

        ResponseEntity<Board> entity = new ResponseEntity<>(board, HttpStatus.OK);
        return entity;
    }

    @DeleteMapping("/{boardNo}")
    public ResponseEntity<String> remove(@PathVariable("boardNo") int boardNo) {
        log.info("remove");
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PutMapping("/{boardNo}")
    public ResponseEntity<String> modify(@PathVariable("boardNo") int boardNo,
                                         @RequestBody Board board) {
        log.info("modify");
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        return entity;
    }

    @PatchMapping("/{boardNo}")
    public ResponseEntity<String> modifyByPatch(@PathVariable("boardNo") int boardNo,
                                                @RequestBody Board board) {
        log.info("modifyByPatch");
        ResponseEntity<String> entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);

        return entity;
    }
}
