package com.example.board.board.controller;

import java.util.List;

import com.example.board.board.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.example.board.board.service.BoardService;

@Controller
@Slf4j
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/board/openBoardList.do")
    public ModelAndView openBoardList() throws Exception{

        ModelAndView mv = new ModelAndView("/board/boardList");
        log.debug("openBoardList");
        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list",list);

        return mv;
    }

    @RequestMapping("/board/openBoardWrite.do")
    public String openBoardWrite() throws Exception{
        return "/board/boardWrite";
    }

    @RequestMapping("/board/insertBoard.do")
    public String insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        boardService.insertBoard(board, null);
        return "redirect:/board/openBoardList.do";
    }
    @RequestMapping("/board/openBoardDetail.do")
    public ModelAndView openBoardDetail(@RequestParam("board_idx") int boardIdx) throws Exception{
        ModelAndView mv = new ModelAndView("/board/boardDetail");

        BoardDto board = boardService.selectBoardDetail(boardIdx);
        mv.addObject("board",board);

        return mv;
    }

    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(BoardDto board) throws Exception{
        boardService.updateBoard(board);
        return "redirect:/board/openBoardList.do";
    }

    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(int boardIdx) throws Exception{
        boardService.deleteBoard(boardIdx);
        return "redirect:/board/openBoardList.do";
    }
}
