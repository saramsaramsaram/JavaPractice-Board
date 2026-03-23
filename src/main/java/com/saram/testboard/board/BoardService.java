package com.saram.testboard.board;

import com.saram.testboard.user.User;
import com.saram.testboard.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardResponse create(BoardRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new RuntimeException("User Not Found"));
        Board board = new Board();
        board.setTitle(request.getTitle());
        board.setContent(request.getContent());
        board.setUser(user);

        Board saved = boardRepository.save(board);

        return BoardResponse.builder().id(saved.getId()).title(saved.getTitle()).content(saved.getContent()).userName(saved.getUser().getName()).build();

    }
}
