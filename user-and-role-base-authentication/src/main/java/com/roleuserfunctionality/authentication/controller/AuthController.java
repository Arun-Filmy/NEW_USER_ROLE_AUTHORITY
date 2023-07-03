package com.roleuserfunctionality.authentication.controller;

import com.roleuserfunctionality.authentication.dto.UserDto;
import com.roleuserfunctionality.authentication.dto.UserRegistrationDto;
import com.roleuserfunctionality.authentication.entity.Users;
import com.roleuserfunctionality.authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserRegistrationDto userRegistrationDto) {
        UserDto registeredUser = userService.registerUser(userRegistrationDto);
        return ResponseEntity.ok(registeredUser);
    }

    @GetMapping("/fetch/{id}")
    public String getUserById(@PathVariable Long id) {
        Users user = userService.getUserById(id);
        return "The details are " + HttpStatus.OK + "  " + user.toString();
    }

}

