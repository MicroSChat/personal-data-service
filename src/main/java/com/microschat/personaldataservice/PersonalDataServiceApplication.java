package com.microschat.personaldataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.microschat.*")
@ComponentScan(basePackages = "com.microschat.*")
public class PersonalDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonalDataServiceApplication.class, args);
    }

}
