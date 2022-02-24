package com.meetup.meetup.moims.controller;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class MoimApiControllerTest {
/*
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
*/
}