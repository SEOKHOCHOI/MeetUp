package com.meetup.meetup.users.controller;

import com.meetup.meetup.users.domain.Address;
import com.meetup.meetup.users.domain.User;
import com.meetup.meetup.users.domain.UsersType;
import com.meetup.meetup.users.dtos.UserSaveRequestDto;
import com.meetup.meetup.users.dtos.UserUpdateRequestDto;
import com.meetup.meetup.users.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    MockMvc mvc;

    @AfterEach
    void cleanUp() {
        userRepository.deleteAll();
    }

    @Test
    void 유저_정보를_조회한다() throws Exception {
        //given
        String email = "test@test.com";
        String password = "1234";
        Address address = Address.builder()
                .city("city")
                .street("street")
                .zipcode("12345")
                .latitude("36.21353")
                .longitude("123.124545")
                .build();
        String picturePath = "~/test.jpg";
        UsersType type = UsersType.USER;

        //when
        User user = User.builder()
                .email(email)
                .password(password)
                .address(address)
                .picturePath(picturePath)
                .type(type)
                .build();

        userRepository.save(user);

        //then
        mvc.perform(get("/users/"+user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", email).exists())
                .andExpect(jsonPath("$.picturePath", picturePath).exists())
                .andExpect(jsonPath("$.type", type).exists());
    }

    @Test
    void 유저를_등록한다() {
        //given
        String email = "test@test.com";
        String password = "1234";
        Address address = Address.builder()
                .city("city")
                .street("street")
                .zipcode("12345")
                .latitude("36.21353")
                .longitude("123.124545")
                .build();
        String picturePath = "~/test.jpg";
        UsersType type = UsersType.USER;

        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .email(email)
                .password(password)
                .address(address)
                .picturePath(picturePath)
                .type(type)
                .build();

        String url = "http://localhost:" + port + "/users";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getEmail()).isEqualTo(email);
        assertThat(users.get(0).getPassword()).isEqualTo(password);
        assertThat(users.get(0).getAddress()).isEqualTo(address);
        assertThat(users.get(0).getPicturePath()).isEqualTo(picturePath);
        assertThat(users.get(0).getType()).isEqualTo(UsersType.USER);
    }

    @Test
    void 유저를_수정한다() {
        //given
        String email = "test@test.com";
        String password = "1234";
        Address address = Address.builder()
                .city("city")
                .street("street")
                .zipcode("12345")
                .latitude("36.21353")
                .longitude("123.124545")
                .build();
        String picturePath = "~/test.jpg";
        UsersType type = UsersType.USER;

        User user = User.builder()
                .email(email)
                .password(password)
                .address(address)
                .picturePath(picturePath)
                .type(type)
                .build();

        User savedUser = userRepository.save(user);

        String newPassword = "qwer";
        Address newAddress = Address.builder()
                .city("newCity")
                .street("newStreet")
                .zipcode("67890")
                .latitude("110.12314214")
                .longitude("58.2139213")
                .build();
        String newPicturePath = "~/newTest.jpg";

        UserUpdateRequestDto requestDto = UserUpdateRequestDto.builder()
                .password(newPassword)
                .address(newAddress)
                .picturePath(newPicturePath)
                .build();

        String url = "http://localhost:" + port + "/users/" + savedUser.getId();

        HttpEntity<UserUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getPassword()).isEqualTo(newPassword);
        assertThat(users.get(0).getAddress()).isEqualTo(newAddress);
        assertThat(users.get(0).getPicturePath()).isEqualTo(newPicturePath);

    }
}