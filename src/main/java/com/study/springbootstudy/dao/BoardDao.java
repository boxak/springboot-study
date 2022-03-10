package com.study.springbootstudy.dao;

import com.study.springbootstudy.domain.Board;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface BoardDao {
    void create(Board board) throws SQLException;
    Board read(Integer boardNo) throws SQLException;
    void update(Board board) throws SQLException;
    void delete(Integer boardNo) throws SQLException;
    List<Board> list() throws SQLException;
}
