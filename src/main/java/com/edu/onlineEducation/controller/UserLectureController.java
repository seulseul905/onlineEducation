package com.edu.onlineEducation.controller;

import com.edu.onlineEducation.entity.UserLecture;
import com.edu.onlineEducation.service.UserLectureService;
import com.edu.onlineEducation.service.dto.userLecture.CreateUserLectureRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.DeleteUserLectureRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.UpdateUserLectureRequestDto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/lecture")
@Slf4j
public class UserLectureController {
    // FE API Request -> Controller -> Service -> Repository -> DB
    // FE <-> BE 요청해보고 전달되었는지 확인가능
    // FE >-< BE FE에 물어봐야함. Spring filter, Controller, 로그 확인

    // API Request(진입점) -> Controller 1차
        // 로그 확인
        // 요청, 응답에 대한 HTTP Status 나 오류 메세지 확인

    // Internal Service Exception(500)

    // Controller -> Service 2차
    // Service -> Repository -> DB 3차

    @Autowired
    private UserLectureService userLectureService;

    @GetMapping("/list")
    public ResponseEntity<List<UserLecture>> getUserList() {
        return ResponseEntity.ok(userLectureService.getUserList());
    }

    @PostMapping("/create")
    public ResponseEntity<UserLecture> createUser(@RequestBody CreateUserLectureRequestDto requestDto) {
        return ResponseEntity.ok(userLectureService.createUserLectureMapping(requestDto));
    }

    @PostMapping("/update")
    public ResponseEntity<UserLecture> updateUser(@RequestBody UpdateUserLectureRequestDto requestDto) {
        return ResponseEntity.ok(userLectureService.updateUserLecture(requestDto));
    }

    @PostMapping("/delete")
    public ResponseEntity<UserLecture> deleteUser(@RequestBody DeleteUserLectureRequestDto requestDto) {
        return ResponseEntity.ok(userLectureService.deleteUserLecture(requestDto.getEduId()));
    }
}
