package com.example.onlineEducation.controller;

import com.example.onlineEducation.entity.User;
import com.example.onlineEducation.service.UserService;
import com.example.onlineEducation.service.dto.CreateUserRequestDto;
import com.example.onlineEducation.service.dto.DeleteUserRequestDto;
import com.example.onlineEducation.service.dto.UpdateUserRequestDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequestDto requestDto) {
        return ResponseEntity.ok(userService.createUser(requestDto));
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody UpdateUserRequestDto requestDto) {
        return ResponseEntity.ok(userService.updateUser(requestDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<User> deleteUser(@RequestBody DeleteUserRequestDto requestDto) {
        return ResponseEntity.ok(userService.deleteUser(requestDto.getId()));
    }
}
