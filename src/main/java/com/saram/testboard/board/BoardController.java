package com.saram.testboard.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping
    public BoardResponse create(@RequestBody BoardRequest request) {
        return boardService.create(request);
    }

    @GetMapping
    public List<BoardResponse> getPosts() {
        return boardService.getPosts();
    }

    @GetMapping("/{id}")
    public BoardResponse getPost(@PathVariable Long id) {
        return boardService.getPost(id);
    }
}
