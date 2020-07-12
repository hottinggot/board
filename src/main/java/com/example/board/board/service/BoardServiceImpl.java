package com.example.board.board.service;

import com.example.board.board.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.board.board.mapper.BoardMapper;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception{
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        boardMapper.insertBoard(board);
    }

    @Override
    public BoardDto selectBoardDetail(int boardIdx) throws Exception{
        boardMapper.updateHitCount(boardIdx);

        BoardDto board = boardMapper.selectBoardDetail(boardIdx);

        return board;
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception{
        boardMapper.updateBoard(board);
    }

    @Override
    public  void deleteBoard(int boardIdx) throws Exception{
        boardMapper.deleteBoard(boardIdx);
    }
}
