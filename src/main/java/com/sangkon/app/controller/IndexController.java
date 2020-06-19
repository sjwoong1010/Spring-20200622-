package com.sangkon.app.controller;

import com.sangkon.app.domain.Board;
import com.sangkon.app.repository.BoardRepository;
import com.sangkon.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    private BoardRepository boardRepository;
    private UserRepository userRepository;

    public IndexController(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Board> boardList = boardRepository.findAllByContent("콘텐츠1");
        model.addAttribute("boardList", boardList);
        return "index";
    }
}
