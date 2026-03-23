package com.saram.testboard.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(user -> UserResponse.builder().id(user.getId()).name(user.getName()).build()).toList();
    }

    public UserResponse getUsers(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));

        return UserResponse.builder().id(user.getId()).name(user.getName()).build();
    }
}
