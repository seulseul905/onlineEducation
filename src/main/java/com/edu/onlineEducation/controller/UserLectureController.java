package com.edu.onlineEducation.controller;

import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.entity.UserLecture;
import com.edu.onlineEducation.service.UserLectureService;
import com.edu.onlineEducation.service.UserService;
import com.edu.onlineEducation.service.dto.user.CreateUserRequestDto;
import com.edu.onlineEducation.service.dto.user.DeleteUserRequestDto;
import com.edu.onlineEducation.service.dto.user.UpdateUserRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.CreateUserLectureRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.DeleteUserLectureRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.UpdateUserLectureRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/lecture")
public class UserLectureController {

    @Autowired
    private UserLectureService userLectureService;

    @GetMapping("/list")
    public ResponseEntity<List<UserLecture>> getUserList() {
        return ResponseEntity.ok(userLectureService.getUserList());
    }

    @PostMapping("/create")
    public ResponseEntity<UserLecture> createUser(@RequestBody CreateUserLectureRequestDto requestDto) {
        return ResponseEntity.ok(userLectureService.createUserLecture(requestDto));
    }

    @PostMapping("/update")
    public ResponseEntity<UserLecture> updateUser(@RequestBody UpdateUserLectureRequestDto requestDto) {
        return ResponseEntity.ok(userLectureService.updateUserLecture(requestDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<UserLecture> deleteUser(@RequestBody DeleteUserLectureRequestDto requestDto) {
        return ResponseEntity.ok(userLectureService.deleteUserLecture(requestDto.getId()));
    }
}
