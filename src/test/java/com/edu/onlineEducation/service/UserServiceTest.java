package com.edu.onlineEducation.service;

import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.repository.UserRepository;
import com.edu.onlineEducation.service.dto.UserType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void createUser() {
        // given

        // given : 멤버를 저장하기 위한 준비 과정
        final String loginId = "test1";
        final String name = "테스트 사용자";
        final String password = "12345";
        final String phone = "01011112222";
        final UserType userType = UserType.valueOf("STUDENT");
        final boolean useYn = true;
        final LocalDateTime createdAt = LocalDateTime.now();
        final LocalDateTime updatedAt = LocalDateTime.now();

        final User user = User.builder()
                                .loginId(loginId)
                                .name(name)
                                .password(password)
                                .phone(phone)
                                .userType(userType)
                                .useYn(useYn)
                                .createdAt(createdAt)
                                .updatedAt(updatedAt).build();
        // when : 실제로 멤버를 저장
//        final User result = UserRepository.save(user);

        // then
//        assertThat(result.getId()).isNotNull();
//        assertThat(result.getLoginId()).isEqualTo("test1");
//        assertThat(result.getName()).isEqualTo("테스트");
//        assertThat(result.getPassword()).isEqualTo("12345");
//        assertThat(result.getPhone()).isEqualTo("01011112222");
//        assertThat(result.getUserType()).isEqualTo(UserType.valueOf("1"));
    }
    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}