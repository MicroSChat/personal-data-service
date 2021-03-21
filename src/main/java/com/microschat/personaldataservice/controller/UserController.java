package com.microschat.personaldataservice.controller;

import com.microschat.commonlibrary.UserInformationMessage;
import com.microschat.personaldataservice.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public ResponseEntity<Long> addUser(@RequestBody UserInformationMessage userInformationMessage){
        return ResponseEntity.ok(userService.addUser(userInformationMessage));
    }

}
