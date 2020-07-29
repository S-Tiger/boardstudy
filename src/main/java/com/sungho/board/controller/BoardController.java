package com.sungho.board.controller;

import com.sungho.board.dto.BoardDto;
import com.sungho.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {
    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(@RequestParam(value = "page", defaultValue = "1") Integer pageNum, Model model){
        List<BoardDto> boardDtoList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("pageList", pageList);
        return "board/list";
    }

    @GetMapping("/post")
    public String write(){
        return "board/write";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto",boardDto);
        return "board/detail";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto",boardDto);
        return "board/update";
    }

    @PostMapping("/post/edit/{no}")
    public String update(BoardDto boardDto){
        boardService.savePost(boardDto);
        return "redirect:/";
    }

    @PostMapping("/post/delete/{no}")
    public String delete(@PathVariable("no") Long id){
        boardService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model){
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
        model.addAttribute("boardList",boardDtoList);
        return "board/list";
    }
}
