package com.edu.onlineEducation.controller;

import com.edu.onlineEducation.entity.Lecture;
import com.edu.onlineEducation.service.LectureUserService;
import com.edu.onlineEducation.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/lecture")

public class LectureUserController {

    @Autowired
    private LectureUserService lectureUserService;

    @GetMapping("/list")
    public ResponseEntity<List<Lecture>> getUserList() {
        return ResponseEntity.ok(lectureUserService.getInstructorUserList());
    }

    @PostMapping("/create")
    public ResponseEntity<Lecture> createUser(@RequestBody CreateLectureRequestDto requestDto) {
        return ResponseEntity.ok(lectureUserService.createUser(requestDto));
    }

    @PostMapping("/update")
    public ResponseEntity<Lecture> updateUser(@RequestBody UpdateLectureRequestDto requestDto) {
        return ResponseEntity.ok(lectureUserService.updateUser(requestDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<Lecture> deleteUser(@RequestBody DeleteLectureRequestDto requestDto) {
        return ResponseEntity.ok(lectureUserService.deleteUser(requestDto.getLectureId()));
    }
}
