package com.meetup.meetup.users.repository;

import com.meetup.meetup.users.domain.Address;
import com.meetup.meetup.users.domain.User;
import com.meetup.meetup.users.domain.UsersType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void userTest() {
        //given
        Address address = new Address("city", "street", "12345", "34.2131231", "126.2312344");
        User user = new User("test@test.com", "1234", address, "~/test.jpg", UsersType.USER);
        userRepository.save(user);

        //when
        User findUser = userRepository.findById(user.getId()).get();

        //then
        assertThat(user).isEqualTo(findUser);
    }

    @Test
    void findEmailTest() {
        //given
        Address address = new Address("city", "street", "12345", "34.2131231", "126.2312344");
        User user = new User("test@test.com", "1234", address, "~/test.jpg", UsersType.USER);
        userRepository.save(user);

        //when
        User findUser = userRepository.findByEmail("test@test.com");

        //then
        assertThat(user).isEqualTo(findUser);
    }
}