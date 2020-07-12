package com.example.board.board.controller;

import com.example.board.board.dto.BoardDto;
import com.example.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController //결과값을 json으로 만들어줌
public class RestBoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value="/api/board", method=RequestMethod.GET)
    public List<BoardDto> openBoardList() throws Exception{
        return boardService.selectBoardList();
    }

    //RequestBody는 파라미터가 반드시 http패킷의 body에 담겨있어야 함을 의미.
    @RequestMapping(value = "/api/board/write", method = RequestMethod.POST)
    public void insertBoard(@RequestBody BoardDto board) throws Exception{
       boardService.insertBoard(board, null);
    }

    @RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.GET)
    public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception{
        return boardService.selectBoardDetail(boardIdx);
    }

    @RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.PUT)
    public String updateBoard(@RequestBody BoardDto board) throws Exception{
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/api/board/{boardIdx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception{
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }
}
