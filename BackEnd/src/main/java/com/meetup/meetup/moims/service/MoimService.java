package com.meetup.meetup.moims.service;

import com.meetup.meetup.moims.domain.Moim;
import com.meetup.meetup.moims.dtos.MoimUpdateRequestDto;
import com.meetup.meetup.moims.repository.MoimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MoimService {

    private final MoimRepository moimRepository;

    @Transactional
    public Long update(Long id, MoimUpdateRequestDto requestDto) {
        Moim moim = moimRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 방입니다. id=" + id));

        moim.update(requestDto.getTitle(), requestDto.getPassword(), requestDto.getHeadCount(), requestDto.getCategory());

        return moim.getId();
    }
}
