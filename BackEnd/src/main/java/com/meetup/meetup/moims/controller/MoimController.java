package com.meetup.meetup.moims.controller;

import com.meetup.meetup.moims.dto.MoimDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
public class MoimController {

    @GetMapping("/moims/{id}")
    public MoimDto findMoim(@PathVariable(name = "id") Long moimId) {
        return null;
    }

    @GetMapping("/moims")
    public Page<MoimDto> findMoims() {
        return null;
    }

    @GetMapping("/history")
    public Page<MoimDto> findHistory() {
        return null;
    }

    @GetMapping("/moims/{id}/places")
    public Page<MoimDto> searchMeetingLocation(@PathVariable(name = "id") Long moimId) {
        return null;
    }

    @PostMapping("/moims")
    public String saveMoim() {
        return null;
    }

    @PostMapping("/moims/{id}/users")
    public String enterUserInMoim(@PathVariable(name = "id") Long moimId) {
        return null;
    }

    @PutMapping("/moims/{id}")
    public String updateMoim(@PathVariable(name = "id") Long moimId) {
        return null;
    }

    @DeleteMapping("/moims/{id}")
    public String deleteMoim(@PathVariable(name = "id") Long moimId) {
        return null;
    }

}
