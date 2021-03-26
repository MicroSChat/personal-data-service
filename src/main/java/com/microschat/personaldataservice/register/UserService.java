package com.microschat.personaldataservice.register;

import com.microschat.commonlibrary.UserInformationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RabbitListener(queues = RegistrationMessagingConfiguration.REGISTRATION_USER_QUEUE_NAME)
    public void addUser(UserInformationMessage userInformationMessage) {

        log.info("Received registration request on queue {}: {}",
                RegistrationMessagingConfiguration.REGISTRATION_USER_QUEUE_NAME,
                userInformationMessage);
        User user = User.builder()
                .username(userInformationMessage.getUsername())
                .nickname(userInformationMessage.getNickname())
                .email(userInformationMessage.getEmail())
                .build();
        try {
            User savedUser = userRepository.saveAndFlush(user);
            log.info("Saved user {}", savedUser);
        } catch (RuntimeException e) {
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
