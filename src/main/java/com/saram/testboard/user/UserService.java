package com.saram.testboard.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse create(UserRequest request) {
        User user = new User();
        user.setName(request.getName());

        User saved = userRepository.save(user);

        return UserResponse.builder().id(saved.getId()).name(saved.getName()).build();
    }
}
