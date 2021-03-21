package com.microschat.personaldataservice.controller;

import com.microschat.personaldataservice.entity.User;
import com.microschat.personaldataservice.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    UserRepository userRepository;

    @Test
    public void addUserTest() {
        //ResponseEntity<Long> id = userController.addUser("mitch", "mitch", "mitch@gmail.com");
//        Optional<User> optionalUser = userRepository.findById(id.getBody());
//        User user = optionalUser.get();
//
//        assertThat(user.getUsername()).isEqualTo("mitch");
//        assertThat(user.getNickname()).isEqualTo("mitch");
//        assertThat(user.getEmail()).isEqualTo("mitch@gmail.com");
    }

}