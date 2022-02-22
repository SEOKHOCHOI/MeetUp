package com.meetup.meetup.likes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LikeController {

    @PostMapping("/places/{id}/likes")
    public String saveLike(@PathVariable(name = "id") Long locationId) {
        return null;
    }

    @GetMapping("/users/{id}/likes")
    public String findLikeList(@PathVariable(name = "id") Long userId) {
        return null;
    }

}
