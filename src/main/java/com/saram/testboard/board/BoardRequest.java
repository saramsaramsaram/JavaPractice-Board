package com.saram.testboard.board;

import lombok.Getter;

@Getter
public class BoardRequest {
    private String title;
    private String content;
    private Long userId;
}
