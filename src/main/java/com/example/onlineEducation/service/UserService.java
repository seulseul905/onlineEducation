package com.example.onlineEducation.service;

import com.example.onlineEducation.entity.User;
import com.example.onlineEducation.repository.UserRepository;
import com.example.onlineEducation.service.dto.CreateUserRequestDto;
import com.example.onlineEducation.service.dto.UpdateUserRequestDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAllByUseYn(true);
    }

    @Transactional
    public User createUser(CreateUserRequestDto requestDto) {

        if (requestDto.getUserId() == null || requestDto.getUserName() == null) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        return userRepository.save(
            User.builder().userId(requestDto.getUserId()).userName(requestDto.getUserName()).useYn(true).build());
    }

    @Transactional
    public User updateUser(UpdateUserRequestDto requestDto) {
        if (requestDto.getUserName().isBlank()) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }
        User existUser = userRepository.findById(requestDto.getId()).orElseThrow(RuntimeException::new);
        existUser.setUserName(requestDto.getUserName());
        return existUser;
    }

    @Transactional
    public User deleteUser(long id) {
        User existUser = userRepository.findById(id).orElseThrow(RuntimeException::new);
        existUser.setUseYn(false);
        return existUser;
    }
}
