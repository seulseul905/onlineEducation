package com.edu.onlineEducation.controller;

import com.edu.onlineEducation.entity.Student;
import com.edu.onlineEducation.service.StudentUserService;
import com.edu.onlineEducation.service.dto.CreateStudentRequestDto;
import com.edu.onlineEducation.service.dto.DeleteStudentRequestDto;
import com.edu.onlineEducation.service.dto.UpdateStudentRequestDto;

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

public class StudentUserController {

    @Autowired
    private StudentUserService studentUserService;

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getUserList() {
        return ResponseEntity.ok(studentUserService.getUserList());
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createUser(@RequestBody CreateStudentRequestDto requestDto) {
        return ResponseEntity.ok(studentUserService.createUser(requestDto));
    }

    @PostMapping("/update")
    public ResponseEntity<Student> updateUser(@RequestBody UpdateStudentRequestDto requestDto) {
        return ResponseEntity.ok(studentUserService.updateUser(requestDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<Student> deleteUser(@RequestBody DeleteStudentRequestDto requestDto) {
        return ResponseEntity.ok(studentUserService.deleteUser(requestDto.getStudentId()));
    }
}
