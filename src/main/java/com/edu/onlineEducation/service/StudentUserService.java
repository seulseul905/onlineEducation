package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.Student;
import com.edu.onlineEducation.repository.StudentUserRepository;
import com.edu.onlineEducation.service.dto.CreateStudentRequestDto;
import com.edu.onlineEducation.service.dto.UpdateStudentRequestDto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentUserService {

    @Autowired
    private StudentUserRepository studentuserRepository;

    public List<Student> getUserList() {
        return studentuserRepository.findAllByStudentUserUseYn(true);
    }

    @Transactional
    public Student createUser(CreateStudentRequestDto requestDto) {

        if (requestDto.getStudentUserId() == null || requestDto.getStudentUserName() == null
            || requestDto.getStudentUserPassword() == null || requestDto.getStudentUserPhone() == null) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        return studentuserRepository.save(
            Student.builder()
                    .studentUserId(requestDto.getStudentUserId())
                    .studentUserName(requestDto.getStudentUserName())
                    .studentUserPassword(requestDto.getStudentUserPassword())
                    .studentUserPhone(requestDto.getStudentUserPhone()).studentUserLecture(requestDto.getStudentUserLecture())
                    .studentUserUseYn(true).build());
    }

    @Transactional
    public Student updateUser(UpdateStudentRequestDto requestDto) {
        if (requestDto.getStudentUserName().isBlank()) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        Student existUser = studentuserRepository.findById(requestDto.getStudentId()).orElseThrow(RuntimeException::new);
        if(requestDto.getStudentUserId() != null){
            existUser.setStudentUserId(requestDto.getStudentUserId());
        }
        if(requestDto.getStudentUserPassword() != null){
            existUser.setStudentUserPassword(requestDto.getStudentUserPassword());
        }
        if(requestDto.getStudentUserPhone() != null){
            existUser.setStudentUserPhone(requestDto.getStudentUserPhone());
        }
        if(requestDto.getStudentUserLecture() != null){
            existUser.setStudentUserLecture(requestDto.getStudentUserLecture());
        }
        existUser.setStudentUserName(requestDto.getStudentUserName());
        return existUser;
    }

    @Transactional
    public Student deleteUser(long studentId) {
        Student existUser = studentuserRepository.findById(studentId).orElseThrow(RuntimeException::new);
        existUser.setStudentUserUseYn(false);
        return existUser;
    }
}
