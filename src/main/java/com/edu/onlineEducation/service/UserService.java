package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.exception.UserNotFoundException;
import com.edu.onlineEducation.repository.UserRepository;
import com.edu.onlineEducation.service.dto.user.CreateUserRequestDto;
import com.edu.onlineEducation.service.dto.user.UpdateUserRequestDto;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;
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

        if (requestDto.getLoginId() == null || requestDto.getName() == null
            || requestDto.getPassword() == null || requestDto.getPhone() == null) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }

        String encryptPassword = Base64.getEncoder()
            .encodeToString(requestDto.getPassword().getBytes(StandardCharsets.UTF_8));
        return userRepository.save(
            User.builder()
                .loginId(requestDto.getLoginId())
                .name(requestDto.getName())
                .password(encryptPassword)
                .phone(replacePhoneNumber(requestDto.getPhone()))
                .userType(requestDto.getUserType())
                .useYn(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
    }

    @Transactional
    public User updateUser(UpdateUserRequestDto requestDto) {

        if (requestDto.getName().isBlank()) {
            throw new IllegalArgumentException("필수값이 없습니다.");
        }

        User existUser = userRepository.findByIdAndUseYn(requestDto.getId(), true)
            .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));

        if(requestDto.getPassword() != null){
            String encryptPassword = Base64.getEncoder().encodeToString(requestDto.getPassword().getBytes(
                    StandardCharsets.UTF_8));
            if(!existUser.getPassword().equals(encryptPassword)){
                existUser.setPassword(requestDto.getPassword());
            }
        }

        if (requestDto.getPhone() != null) {
            existUser.setPhone(replacePhoneNumber(requestDto.getPhone()));
        }
        if (requestDto.getUserType() != null) {
            existUser.setUserType(requestDto.getUserType());
        }
        existUser.setName(requestDto.getName());
        existUser.setUseYn(requestDto.isUseYn());
        existUser.setUpdatedAt(LocalDateTime.now());

        return existUser;
    }

    @Transactional
    public User deleteUser(long id) {
        User existUser = userRepository.findByIdAndUseYn(id, true)
            .orElseThrow(() -> new UserNotFoundException("사용자 정보가 없습니다."));
        existUser.setUseYn(false);
        existUser.setUpdatedAt(LocalDateTime.now());
        return existUser;
    }

    private String replacePhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.contains("-")) {
            return phoneNumber.replaceAll("-", "");
        }
        return phoneNumber;
    }
}


