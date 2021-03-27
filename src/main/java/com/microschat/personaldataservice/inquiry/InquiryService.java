package com.microschat.personaldataservice.inquiry;

import com.microschat.commonlibrary.UserInformationMessage;
import com.microschat.personaldataservice.connectivity.MessagingConfiguration;
import com.microschat.personaldataservice.user.User;
import com.microschat.personaldataservice.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class InquiryService {

    private final UserRepository userRepository;

    @Autowired
    public InquiryService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RabbitListener(queues = MessagingConfiguration.INQUIRY_USER_QUEUE_NAME)
    public UserInformationMessage inquireUser(String username){
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()){
            return null;
        }

        User user = userOptional.get();

        log.info("Got inquiry for {}, returning {}", username, user);

        return UserInformationMessage.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .username(user.getUsername())
                .build();
    }
}
