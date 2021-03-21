package com.microschat.personaldataservice.service;

import com.microschat.commonlibrary.UserInformationMessage;
import com.microschat.personaldataservice.entity.User;
import com.microschat.personaldataservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Long addUser(UserInformationMessage userInformationMessage){
        User user = User.builder()
                .username(userInformationMessage.getUsername())
                .nickname(userInformationMessage.getNickname())
                .email(userInformationMessage.getEmail())
                .build();

        User savedUser = userRepository.saveAndFlush(user);
        log.info("Saved user {}", savedUser);
        return savedUser.getId();
    }
}
