package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.UserLecture;
import com.edu.onlineEducation.exception.UserNotFoundException;
import com.edu.onlineEducation.repository.UserLectureRepository;
import com.edu.onlineEducation.service.dto.userLecture.CreateUserLectureRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.UpdateUserLectureRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserLectureService {

    @Autowired
    private UserLectureRepository userLectureRepository;

    public List<UserLecture> getUserList() {
        return userLectureRepository.findAllByClassUseYn(true);
    }

    @Transactional
    public UserLecture createUserLecture(CreateUserLectureRequestDto requestDto) {

        if (requestDto.getId() == null) {
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

        UserLecture existUser = userLectureRepository.findByEduIdAndClassUseYn(requestDto.getEduId(), true)
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
    public UserLecture deleteUserLecture(long id) {
        UserLecture existUser = userLectureRepository.findByEduIdAndClassUseYn(id, true)
            .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
        existUser.setClassUseYn(false);
        existUser.setUpdatedAt(LocalDateTime.now());
        return existUser;
    }

}


