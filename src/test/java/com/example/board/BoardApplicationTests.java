package com.example.board;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.mapper.BoardMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardApplicationTests {

    @Autowired
    private SqlSessionTemplate sqlSession;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSqlSession() throws Exception{
        System.out.println(sqlSession.toString());
    }

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testMapper () throws Exception{
        BoardDto board = new BoardDto();
        board.setTitle("first");
        board.setContents("it");
        board.setCreatorId("admin!");
        boardMapper.insertBoard(board);
        System.out.println(boardMapper.selectBoardList());
    }

}
