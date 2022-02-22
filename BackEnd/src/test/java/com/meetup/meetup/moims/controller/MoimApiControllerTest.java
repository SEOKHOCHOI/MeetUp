package com.meetup.meetup.moims.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meetup.meetup.moims.domain.ActiveType;
import com.meetup.meetup.moims.domain.Category;
import com.meetup.meetup.moims.domain.Moim;
import com.meetup.meetup.moims.dtos.MoimSaveRequestDto;
import com.meetup.meetup.moims.dtos.MoimUpdateRequestDto;
import com.meetup.meetup.moims.repository.MoimRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MoimApiControllerTest {

    @LocalServerPort
    int port;

    @Autowired
    MoimRepository moimRepository;

    @Autowired
    WebApplicationContext context;

    MockMvc mvc;

    @BeforeEach
    void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    
    @AfterEach
    void cleanUp() {
        moimRepository.deleteAll();
    }
    
    @Test
    @WithMockUser(roles = "USER")
    void 모임방을_생성한다() throws Exception {
        //given
        String title = "테스트방";
        String password = "1234";
        int headCount = 8;
        Category category = Category.CE7;
        MoimSaveRequestDto requestDto = MoimSaveRequestDto.builder()
                .title(title)
                .password(password)
                .headCount(headCount)
                .category(category)
                .build();

        String url = "http://localhost:" + port + "/moims";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Moim> moims = moimRepository.findAll();
        assertThat(moims.get(0).getTitle()).isEqualTo(title);
        assertThat(moims.get(0).getPassword()).isEqualTo(password);
        assertThat(moims.get(0).getHeadCount()).isEqualTo(headCount);
        assertThat(moims.get(0).getCategory()).isEqualTo(category);
        assertThat(moims.get(0).getType()).isEqualTo(ActiveType.ACTIVE);
    }

    @Test
    @WithMockUser(roles = "USER")
    void 모임방을_조회한다() throws Exception {
        String title = "테스트방";
        String password = "1234";
        int headCount = 8;
        Category category = Category.CE7;
        ActiveType type = ActiveType.ACTIVE;

        Moim moim = Moim.builder()
                .title(title)
                .password(password)
                .headCount(headCount)
                .category(category)
                .type(type)
                .build();

        moimRepository.save(moim);

        mvc.perform(get("/moims/" + moim.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value(title))
                .andExpect(jsonPath("$.headCount").value(headCount))
                .andExpect(jsonPath("$.category").value(category.toString()))
                .andExpect(jsonPath("$.type").value(type.toString()));
    }

    @Test
    @WithMockUser(roles = "USER")
    void 모임방을_수정한다() throws Exception {
        //given
        String title = "테스트방";
        String password = "1234";
        int headCount = 8;
        Category category = Category.CE7;
        ActiveType type = ActiveType.ACTIVE;

        Moim moim = Moim.builder()
                .title(title)
                .password(password)
                .headCount(headCount)
                .category(category)
                .type(type)
                .build();

        moimRepository.save(moim);

        //when
        String newTitle = "테스트방2";
        String newPassword = "qwer";
        int newHeadCount = 4;
        Category newCategory = Category.AD5;

        MoimUpdateRequestDto requestDto = MoimUpdateRequestDto.builder()
                .title(newTitle)
                .password(newPassword)
                .headCount(newHeadCount)
                .category(newCategory)
                .build();

        String url = "http://localhost:" + port + "/moims/" + moim.getId();

        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Moim> moims = moimRepository.findAll();
        assertThat(moims.get(0).getTitle()).isEqualTo(newTitle);
        assertThat(moims.get(0).getPassword()).isEqualTo(newPassword);
        assertThat(moims.get(0).getHeadCount()).isEqualTo(newHeadCount);
        assertThat(moims.get(0).getCategory()).isEqualTo(newCategory);
    }
}