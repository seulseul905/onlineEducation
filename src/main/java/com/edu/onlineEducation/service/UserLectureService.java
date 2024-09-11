package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.entity.UserLecture;
import com.edu.onlineEducation.exception.UserNotFoundException;
import com.edu.onlineEducation.repository.UserLectureRepository;
import com.edu.onlineEducation.repository.UserRepository;
import com.edu.onlineEducation.service.dto.user.CreateUserRequestDto;
import com.edu.onlineEducation.service.dto.user.UpdateUserRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.CreateUserLectureRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.DeleteUserLectureRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.UpdateUserLectureRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.List;

@Service
public class UserLectureService {

    @Autowired
    private UserLectureRepository userLectureRepository;

    public List<UserLecture> getUserList() {
        return userLectureRepository.findAllByUseYn(true);
    }

    @Transactional
    public UserLecture createUserLecture(CreateUserLectureRequestDto requestDto) {

        if (requestDto.getInstructorName() == null) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        return userLectureRepository.save(
            UserLecture.builder()
                .userId(requestDto.getId())
                .lectureId(requestDto.getLectureId())
                .instructorName(requestDto.getInstructorName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
    }

    @Transactional
    public UserLecture updateUserLecture(UpdateUserLectureRequestDto requestDto) {

        if (requestDto.getInstructorName().isBlank()) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }

        UserLecture existUser = userLectureRepository.findByIdAndUseYn(requestDto.getId(), true)
            .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));

        if (requestDto.getId() != null) {
            existUser.setUserId(requestDto.getId());
        }
        if (requestDto.getLectureId() != null) {
            existUser.setLectureId(requestDto.getLectureId());
        }
        existUser.setInstructorName(requestDto.getInstructorName());
        existUser.setUpdatedAt(LocalDateTime.now());

        return existUser;
    }

    @Transactional
    public UserLecture deleteUserLecture(User id) {
        UserLecture existUser = userLectureRepository.findByIdAndUseYn(id, true)
            .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
        existUser.setUpdatedAt(LocalDateTime.now());
        return existUser;
    }

}


