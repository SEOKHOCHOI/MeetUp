package com.meetup.meetup.comments.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {

    @PostMapping("/places/{id}/comments")
    public String saveComment(@PathVariable(name = "id") Long locationId) {
        return null;
    }

    @GetMapping("/places/{id}/comments")
    public String findCommentsInLocation(@PathVariable(name = "id") Long locationId) {
        return null;
    }

    @GetMapping("/users/{id}/comments")
    public String findCommentsByUser(@PathVariable(name = "id") Long userId) {
        return null;
    }

    @PutMapping("/places/{id}/comments")
    public String updateComment(@PathVariable(name = "id") Long locationId) {
        return null;
    }

    @DeleteMapping("/places/{id}/comments")
    public String deleteComment(@PathVariable(name = "id") Long locationId) {
        return null;
    }
}
