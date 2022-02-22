package com.meetup.meetup.users.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @Test
    void 유저_객체_생성하기() {
        //given
        Address address = Address.builder()
                .city("city")
                .street("street")
                .zipcode("12345")
                .latitude("34.23123")
                .longitude("126.213123")
                .build();

        String email = "test@test.com";
        String password = "12345";
        String picturePath = "~/test.jpg";
        Role type = Role.USER;

        //when
        User user = User.builder()
                .email(email)
                .password(password)
                .address(address)
                .picturePath(picturePath)
                .type(type)
                .build();

        //then
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getPassword()).isEqualTo(password);
        assertThat(user.getAddress()).isEqualTo(address);
        assertThat(user.getPicture()).isEqualTo(picturePath);
        assertThat(user.getRole()).isEqualTo(type);

    }
}