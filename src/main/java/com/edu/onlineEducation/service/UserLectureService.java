package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.Lecture;
import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.entity.UserLecture;
import com.edu.onlineEducation.exception.LectuerNotFoundException;
import com.edu.onlineEducation.exception.UserNotFoundException;
import com.edu.onlineEducation.repository.LectureRepository;
import com.edu.onlineEducation.repository.UserLectureRepository;
import com.edu.onlineEducation.repository.UserRepository;
import com.edu.onlineEducation.service.dto.userLecture.CreateUserLectureRequestDto;
import com.edu.onlineEducation.service.dto.userLecture.UpdateUserLectureRequestDto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserLectureService {

    @Autowired
    private UserLectureRepository userLectureRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LectureRepository lectureRepository;

    public List<UserLecture> getUserList() {
        return userLectureRepository.findAllByClassUseYn(true);
    }

    @Transactional
    public UserLecture createUserLectureMapping(CreateUserLectureRequestDto requestDto) {
        // 전제조건 - 사용자가 있어야 한다, 강의가 있어야 한다.

        // 체크항목
        // 1. 필수값 체크
        requestDto.isValid();
        // 2. 필수값으로 데이터 정합성 확인 (정상 사용자, 강의 인지 확인)
        // 사용자 정보 확인
        User user = userRepository.findByIdAndUseYn(requestDto.getUserId(), true)
            .orElseThrow(UserNotFoundException::new);
        // 강의정보 확인
        Lecture lecture = lectureRepository.findByLectureIdAndLectureUseYn(requestDto.getLectureId(), true)
            .orElseThrow(LectuerNotFoundException::new);
        // 3. 비지니스 로직 체크 ( 사용자가 이미 동일한 강의를 신청한 내역이있는지 확인 )
        userLectureRepository.findByUserIdAndLectureIdAndClassUseYn(user.getId(),
            lecture.getLectureId(), true).orElseThrow(() -> new RuntimeException("동일한 강의를 수강한 내역이 존재합니다."));

        // 4. 저장
        return userLectureRepository.save(
            UserLecture.builder()
                .userId(user)
                .lectureId(lecture)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
    }

    @Transactional
    public UserLecture updateUserLecture(UpdateUserLectureRequestDto requestDto) {

        // 사용자가 강의를 취소한다.
        // Case 1) - 필수아님 비지니스 요건
        // 강의가 마감이 되었는데 대기를 등록하는 기능
        // 자리가 생겨서 다시 요청이 가능한 경우 재요청

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


