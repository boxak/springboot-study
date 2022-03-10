package com.study.springbootstudy.dao;

import com.study.springbootstudy.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class JdbcBoardDao implements BoardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Board> mapper = (rs, rowNum) -> {
        Board board = new Board();

        board.setBoardNo(rs.getInt("board_no"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setWriter(rs.getString("writer"));

        Timestamp timestamp = rs.getTimestamp("reg_date");
        board.setRegDate(timestamp.toLocalDateTime());

        return board;
    };

    @Override
    public void create(Board board) throws SQLException {
        String query = "INSERT INTO board (title, content, writer) VALUES (?,?,?)";
        jdbcTemplate.update(query,
                    board.getTitle(),
                    board.getContent(),
                    board.getWriter()
                );
    }

    @Override
    public Board read(Integer boardNo) throws SQLException {
        String query  = "SELECT board_no, title, content, writer, reg_date " +
                        "FROM board " +
                        "where board_no = ?";
        List<Board> results = jdbcTemplate.query(query, mapper, new Object[]{boardNo});
        return CollectionUtils.isEmpty(results) ? null : results.get(0);
    }

    @Override
    public void update(Board board) throws SQLException {
        String query = "UPDATE board SET title = ?, content = ? WHERE board_no = ?";
        jdbcTemplate.update(query,
                    board.getTitle(),
                    board.getContent(),
                    board.getBoardNo()
                );
    }

    @Override
    public void delete(Integer boardNo) throws SQLException {
        String query = "DELETE FROM board where board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }

    @Override
    public List<Board> list() throws SQLException {
        String query =
                "SELECT board_no, title, content, writer, reg_date " +
                        "FROM board " +
                        "WHERE board_no > 0 " +
                        "ORDER BY board_no desc, reg_date DESC";
        List<Board> results = jdbcTemplate.query(query, mapper);
        return results;
    }
}
