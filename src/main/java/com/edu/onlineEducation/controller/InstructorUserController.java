package com.edu.onlineEducation.controller;

import com.edu.onlineEducation.entity.Instructor;
import com.edu.onlineEducation.service.InstructorUserService;
import com.edu.onlineEducation.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/instructor")

public class InstructorUserController {

    @Autowired
    private InstructorUserService instructorUserService;

    @GetMapping("/list")
    public ResponseEntity<List<Instructor>> getUserList() {
        return ResponseEntity.ok(instructorUserService.getInstructorUserList());
    }

    @PostMapping("/create")
    public ResponseEntity<Instructor> createUser(@RequestBody CreateInstructorRequestDto requestDto) {
        return ResponseEntity.ok(instructorUserService.createUser(requestDto));
    }

    @PostMapping("/update")
    public ResponseEntity<Instructor> updateUser(@RequestBody UpdateInstructorRequestDto requestDto) {
        return ResponseEntity.ok(instructorUserService.updateUser(requestDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<Instructor> deleteUser(@RequestBody DeleteInstructorRequestDto requestDto) {
        return ResponseEntity.ok(instructorUserService.deleteUser(requestDto.getInstructorId()));
    }
}
