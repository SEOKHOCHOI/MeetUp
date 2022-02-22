package com.meetup.meetup.moims.controller;

import com.meetup.meetup.moims.dtos.MoimResponseDto;
import com.meetup.meetup.moims.dtos.MoimSaveRequestDto;
import com.meetup.meetup.moims.dtos.MoimUpdateRequestDto;
import com.meetup.meetup.moims.repository.MoimRepository;
import com.meetup.meetup.moims.service.MoimService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MoimApiController {

    private final MoimRepository moimRepository;
    private final MoimService moimService;

    @GetMapping("/moims/{id}")
    public MoimResponseDto findMoim(@PathVariable(name = "id") Long moimId) {
        return moimRepository.findById(moimId).get().toResponseDto();
    }

    @GetMapping("/moims")
    public Page<MoimResponseDto> findMoims() {
        return null;
    }

    @GetMapping("/history")
    public Page<MoimResponseDto> findHistory() {
        return null;
    }

    @GetMapping("/moims/{id}/places")
    public Page<MoimResponseDto> searchMeetingLocation(@PathVariable(name = "id") Long moimId) {
        return null;
    }

    @PostMapping("/moims")
    public Long saveMoim(@RequestBody MoimSaveRequestDto requestDto) {
        return moimRepository.save(requestDto.toEntity()).getId();
    }

    @PostMapping("/moims/{id}/users")
    public String enterUserInMoim(@PathVariable(name = "id") Long moimId) {
        return null;
    }

    @PutMapping("/moims/{id}")
    public Long updateMoim(@PathVariable(name = "id") Long moimId, @RequestBody MoimUpdateRequestDto requestDto) {
        return moimService.update(moimId, requestDto);
    }

    @DeleteMapping("/moims/{id}")
    public String deleteMoim(@PathVariable(name = "id") Long moimId) {
        return null;
    }

}

