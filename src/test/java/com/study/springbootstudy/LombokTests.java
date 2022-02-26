package com.study.springbootstudy;

import com.study.springbootstudy.domain.Board;
import com.study.springbootstudy.domain.Member;
import org.junit.Test;

public class LombokTests {

    @Test
    public void noArgsConstructor() {
        Board board = new Board();
        System.out.println(board);
    }

    @Test
    public void requiredArgsConstructor() {
        Board board = new Board("테스트 제목");
        System.out.println(board);
    }

    @Test
    public void getter() {
        Board board = new Board();
        System.out.println(board.getTitle());
    }

    @Test
    public void setter() {
        Board board = new Board();
        board.setTitle("게시판제목");
        System.out.println(board.getTitle());
    }

    @Test
    public void testToString() {
        Board board = new Board();
        System.out.println(board);
    }

    @Test
    public void toStringExclude() {
        Member member = new Member();
        System.out.println(member);
    }

}
