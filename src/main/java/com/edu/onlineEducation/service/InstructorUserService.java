package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.Instructor;
import com.edu.onlineEducation.entity.Student;
import com.edu.onlineEducation.repository.InstructorUserRepository;
import com.edu.onlineEducation.service.dto.CreateInstructorRequestDto;
import com.edu.onlineEducation.service.dto.CreateStudentRequestDto;
import com.edu.onlineEducation.service.dto.UpdateInstructorRequestDto;
import com.edu.onlineEducation.service.dto.UpdateStudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorUserService {

    @Autowired
    private InstructorUserRepository instructoruserRepository;

    public List<Instructor> getInstructorUserList() {
        return instructoruserRepository.findAllByInstructorUserUseYn(true);
    }

    @Transactional
    public Instructor createUser(CreateInstructorRequestDto requestDto) {

        if (requestDto.getInstructorUserId() == null || requestDto.getInstructorUserName() == null
            || requestDto.getInstructorUserPassword() == null || requestDto.getInstructorUserPhone() == null
            || requestDto.getInstructorUserLecture() == null ) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        return instructoruserRepository.save(
                Instructor.builder()
                    .instructorUserId(requestDto.getInstructorUserId())
                    .instructorUserName(requestDto.getInstructorUserName())
                    .instructorUserPassword(requestDto.getInstructorUserPassword())
                    .instructorUserPhone(requestDto.getInstructorUserPhone())
                    .instructorUserLecture(requestDto.getInstructorUserLecture())
                    .instructorUserUseYn(true).build());
    }

    @Transactional
    public Instructor updateUser(UpdateInstructorRequestDto requestDto) {
        if (requestDto.getInstructorUserName().isBlank()) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        Instructor existUser = instructoruserRepository.findById(requestDto.getInstructorId()).orElseThrow(RuntimeException::new);
        if(requestDto.getInstructorUserId() != null){
            existUser.setInstructorUserId(requestDto.getInstructorUserId());
        }
        if(requestDto.getInstructorUserPassword() != null){
            existUser.setInstructorUserPassword(requestDto.getInstructorUserPassword());
        }
        if(requestDto.getInstructorUserPhone() != null){
            existUser.setInstructorUserPhone(requestDto.getInstructorUserPhone());
        }
        if(requestDto.getInstructorUserLecture() != null){
            existUser.setInstructorUserLecture(requestDto.getInstructorUserLecture());
        }
        existUser.setInstructorUserName(requestDto.getInstructorUserName());
        return existUser;
    }

    @Transactional
    public Instructor deleteUser(long instructorId) {
        Instructor existUser = instructoruserRepository.findById(instructorId).orElseThrow(RuntimeException::new);
        existUser.setInstructorUserUseYn(false);
        return existUser;
    }
}
