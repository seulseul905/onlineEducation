package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.Lecture;
import com.edu.onlineEducation.repository.LectureRepository;
import com.edu.onlineEducation.service.dto.lecture.CreateLectureRequestDto;
import com.edu.onlineEducation.service.dto.lecture.UpdateLectureRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LectureUserService {

    @Autowired
    private LectureRepository lectureRepository;


    public List<Lecture> getInstructorUserList() {
        return lectureRepository.findAllByLectureUseYn(true);
    }

    @Transactional
    public Lecture createUser(CreateLectureRequestDto requestDto) {

        if (requestDto.getLectureInstructorName() == null || requestDto.getLectureStudentName() == null ) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        return lectureRepository.save(
                Lecture.builder()
                    .lectureName(requestDto.getLectureName())
                    .lectureInstructorName(requestDto.getLectureInstructorName())
                    .lectureStudentName(requestDto.getLectureStudentName())
                    .lectureUseYn(true).build());
    }

    @Transactional
    public Lecture updateUser(UpdateLectureRequestDto requestDto) {
        if (requestDto.getLectureName().isBlank()) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        Lecture existUser = lectureRepository.findById(requestDto.getLectureId()).orElseThrow(RuntimeException::new);

        if(requestDto.getLectureInstructorName() != null) {
            existUser.setLectureInstructorName(requestDto.getLectureInstructorName());
        }
        if(requestDto.getLectureStudentName() != null){
            existUser.setLectureStudentName(requestDto.getLectureStudentName());
        }
        existUser.setLectureName(requestDto.getLectureName());
        return existUser;
    }

    @Transactional
    public Lecture deleteUser(long lectureId) {
        Lecture existUser = lectureRepository.findById(lectureId).orElseThrow(RuntimeException::new);
        existUser.setLectureUseYn(false);
        return existUser;
    }
}
