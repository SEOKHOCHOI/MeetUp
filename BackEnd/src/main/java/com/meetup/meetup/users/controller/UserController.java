package com.meetup.meetup.users.controller;

import com.meetup.meetup.users.domain.User;
import com.meetup.meetup.users.dtos.UserResponseDto;
import com.meetup.meetup.users.dtos.UserSaveRequestDto;
import com.meetup.meetup.users.dtos.UserUpdateRequestDto;
import com.meetup.meetup.users.repository.UserRepository;
import com.meetup.meetup.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @PostMapping("")
    public Long save(@RequestBody UserSaveRequestDto requestDto) {

        return userRepository.save(requestDto.toEntity()).getId();
    }

    @PostMapping("/login")
    public String login() {
        return "hi";
    }

    @DeleteMapping("/logout")
    public String logout() {
        return "hi";
    }

    @GetMapping("/{id}")
    public UserResponseDto findUser(@PathVariable(name = "id") Long userId) {

        Optional<User> findUser = userRepository.findById(userId);

        return findUser.get().toResponseDto();
    }

    @PutMapping("/{id}")
    public Long updateUser(@PathVariable(name = "id") Long userId, @RequestBody UserUpdateRequestDto requestDto) {
        Optional<User> findUser = userRepository.findById(userId);
        return userService.update(userId, requestDto);
    }
}
