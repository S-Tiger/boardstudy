package com.sungho.board.controller;


import com.sungho.board.dto.BoardDto;
import com.sungho.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ViewController {

    @Autowired
    private final BoardService boardService;

    @GetMapping("/")
    public String boardList(@RequestParam(value = "page", defaultValue = "1") Integer pageNum, Model model){
        List<BoardDto> boardDtoList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("pageList", pageList);
        return "board/list";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write";
    }
}
