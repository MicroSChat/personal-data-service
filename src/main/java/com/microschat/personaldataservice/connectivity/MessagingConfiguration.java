package com.microschat.personaldataservice.connectivity;

import com.microschat.commonlibrary.connectivity.ConnectivityConstant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessagingConfiguration {

    public final static String REGISTRATION_USER_QUEUE_NAME = "user-inquiry-pds";
    public final static String INQUIRY_USER_QUEUE_NAME = "user-register-pds";

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(ConnectivityConstant.APPLICATION_EXCHANGE);
    }

    @Bean
    Declarables declarables(){
        TopicExchange topicExchange = new TopicExchange(ConnectivityConstant.APPLICATION_EXCHANGE);
        Queue registrationQueue = new Queue(REGISTRATION_USER_QUEUE_NAME, false);
        Queue inquiryQueue = new Queue(INQUIRY_USER_QUEUE_NAME, false);

        return new Declarables(topicExchange,
                registrationQueue,
                inquiryQueue,
                BindingBuilder.bind(registrationQueue).to(topicExchange).with(ConnectivityConstant.USER_REGISTRATION_ROUTING_KEY),
                BindingBuilder.bind(inquiryQueue).to(topicExchange).with(ConnectivityConstant.USER_INQUIRY_ROUTING_KEY));
    }
}
