package com.meetup.meetup.users.dtos;

import com.meetup.meetup.users.domain.UsersType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserResponseDtoTest {

    @Test
    void 롬복_기능_테스트() {
        //given
        String email = "test@test.com";
        String picturePath = "~/test.jpg";
        UsersType type = UsersType.USER;

        //when
        UserResponseDto dto = new UserResponseDto(email, picturePath, type);

        //then
        assertThat(dto.getEmail()).isEqualTo(email);
        assertThat(dto.getPicturePath()).isEqualTo(picturePath);
        assertThat(dto.getType()).isEqualTo(type);
    }
}