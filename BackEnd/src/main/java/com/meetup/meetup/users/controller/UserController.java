package com.meetup.meetup.users.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("")
    public String save() {
        return "hi";
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
    public String findUser(@PathVariable(name = "id") Long userId) {
        return "hi";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable(name = "id") Long userId) {
        return "hi";
    }
}
