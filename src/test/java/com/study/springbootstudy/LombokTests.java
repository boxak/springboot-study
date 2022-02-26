package com.study.springbootstudy;

import com.study.springbootstudy.domain.Board;
import com.study.springbootstudy.domain.Member;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

    @Test
    public void testBoard() {
        Board board1 = new Board();
        board1.setBoardNo(1);
        board1.setTitle("title1");

        Board board2 = new Board();
        board2.setBoardNo(2);
        board2.setTitle("title2");

        Board board3 = new Board();
        board3.setBoardNo(2);
        board3.setTitle("title3");

        Set<Board> boardSet = new HashSet<>();

        boardSet.add(board1);
        boardSet.add(board2);
        boardSet.add(board3);

        System.out.println("저장된 데이터 수 : " + boardSet.size());

        Iterator<Board> iterator = boardSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
