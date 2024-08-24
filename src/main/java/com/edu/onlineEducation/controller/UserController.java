package com.edu.onlineEducation.controller;

import com.edu.onlineEducation.entity.Student;
import com.edu.onlineEducation.service.UserService;
import com.edu.onlineEducation.service.dto.CreateStudentRequestDto;
import com.edu.onlineEducation.service.dto.DeleteUserRequestDto;
import com.edu.onlineEducation.service.dto.UpdateUserRequestDto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/student")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createUser(@RequestBody CreateStudentRequestDto requestDto) {
        return ResponseEntity.ok(userService.createUser(requestDto));
    }

    @PostMapping("/update")
    public ResponseEntity<Student> updateUser(@RequestBody UpdateUserRequestDto requestDto) {
        return ResponseEntity.ok(userService.updateUser(requestDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<Student> deleteUser(@RequestBody DeleteUserRequestDto requestDto) {
        return ResponseEntity.ok(userService.deleteUser(requestDto.getId()));
    }
}
