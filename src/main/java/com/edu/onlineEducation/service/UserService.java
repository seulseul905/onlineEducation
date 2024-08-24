package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.Student;
import com.edu.onlineEducation.repository.StudentUserRepository;
import com.edu.onlineEducation.service.dto.CreateStudentRequestDto;
import com.edu.onlineEducation.service.dto.UpdateUserRequestDto;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

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
    public Student updateUser(UpdateUserRequestDto requestDto) {
        if (requestDto.getUserName().isBlank()) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        Student existUser = studentuserRepository.findById(requestDto.getId()).orElseThrow(RuntimeException::new);
        existUser.setStudentUserName(requestDto.getUserName());
        return existUser;
    }

    @Transactional
    public Student deleteUser(long id) {
        Student existUser = studentuserRepository.findById(id).orElseThrow(RuntimeException::new);
        existUser.setStudentUserUseYn(false);
        return existUser;
    }
}
