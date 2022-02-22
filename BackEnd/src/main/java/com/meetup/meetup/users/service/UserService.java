package com.meetup.meetup.users.service;

import com.meetup.meetup.users.domain.User;
import com.meetup.meetup.users.dtos.UserUpdateRequestDto;
import com.meetup.meetup.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long update(Long id, UserUpdateRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("회원이 존재하지 않습니다. id=" + id));

        user.update(requestDto.getPassword(), requestDto.getAddress(), requestDto.getPicture());

        return user.getId();
    }

}
