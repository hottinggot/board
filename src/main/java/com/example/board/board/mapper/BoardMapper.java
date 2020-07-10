package com.example.board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.board.dto.BoardDto;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList() throws Exception;
    void insertBoard(BoardDto board) throws Exception;
}
