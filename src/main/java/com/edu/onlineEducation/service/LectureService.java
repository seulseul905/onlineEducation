package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.Lecture;
import com.edu.onlineEducation.exception.LectuerNotFoundException;
import com.edu.onlineEducation.repository.LectureRepository;
import com.edu.onlineEducation.service.dto.lecture.CreateLectureRequestDto;
import com.edu.onlineEducation.service.dto.lecture.UpdateLectureRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LectureService {

    @Autowired
    private LectureRepository lectureRepository;


    public List<Lecture> getInstructorUserList() {
        return lectureRepository.findAllByLectureUseYn(true);
    }

    @Transactional
    public Lecture createUser(CreateLectureRequestDto requestDto) {

        if (requestDto.getTitle() == null || requestDto.getPrice() == null || requestDto.getContent() == null) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        return lectureRepository.save(
                Lecture.builder()
                    .title(requestDto.getTitle())
                    .price(requestDto.getPrice())
                    .content(requestDto.getContent())
                    .personnel(requestDto.getPersonnel())
                    .lectureUseYn(true)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .lectureUseYn(true).build());
    }

    @Transactional
    public Lecture updateUser(UpdateLectureRequestDto requestDto) {
        if (requestDto.getTitle().isBlank()) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        Lecture existLecture = lectureRepository.findById(requestDto.getLectureId())
                .orElseThrow(() -> new LectuerNotFoundException("강의 정보가 없습니다."));

        if(requestDto.getPrice() != null && !requestDto.getPrice().equals(existLecture.getPrice())) {
            existLecture.setPrice(requestDto.getPrice());
        }
        if(requestDto.getContent() != null && !requestDto.getContent().equals(existLecture.getContent())){
            existLecture.setContent(requestDto.getContent());
        }
        if(requestDto.getPersonnel() != existLecture.getPersonnel()){
            existLecture.setPersonnel(requestDto.getPersonnel());
        }
        if(requestDto.isLectureUseYn() != existLecture.isLectureUseYn()){
            existLecture.setLectureUseYn(requestDto.isLectureUseYn());
        }
        existLecture.setTitle(requestDto.getTitle());
        existLecture.setUpdatedAt(LocalDateTime.now());
        return existLecture;
    }

    @Transactional
    public Lecture deleteUser(long lectureId) {
        Lecture existUser = lectureRepository.findById(lectureId)
                .orElseThrow(() -> new LectuerNotFoundException("강의 정보가 없습니다."));
        existUser.setLectureUseYn(false);
        return existUser;
    }
}
