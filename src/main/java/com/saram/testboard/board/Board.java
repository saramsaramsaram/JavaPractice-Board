package com.saram.testboard.board;


import com.saram.testboard.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
