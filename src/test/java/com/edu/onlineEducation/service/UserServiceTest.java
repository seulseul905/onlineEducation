package com.edu.onlineEducation.service;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.repository.UserRepository;
import com.edu.onlineEducation.service.dto.UserType;
import com.edu.onlineEducation.service.dto.user.CreateUserRequestDto;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;


    @Test
    void createUser() {
        // given : 멤버를 저장하기 위한 준비 과정
        final String loginId = "test1";
        final String name = "테스트 사용자";
        final String password = "12345";
        final String phone = "01011112222";
        final UserType userType = UserType.valueOf("STUDENT");
        final boolean useYn = true;
        final LocalDateTime createdAt = LocalDateTime.now();
        final LocalDateTime updatedAt = LocalDateTime.now();

        CreateUserRequestDto requestDto = new CreateUserRequestDto(loginId, name, password, phone, userType);

        final User user = User.builder()
            .loginId(loginId)
            .name(name)
            .password(password)
            .phone(phone)
            .userType(userType)
            .useYn(useYn)
            .createdAt(createdAt)
            .updatedAt(updatedAt).build();

        // when
        when(userRepository.save(any())).thenReturn(user);

        // then
        userService.createUser(requestDto);
        verify(userRepository, times(1)).save(any());
    }

    @Test
    void createUser_loginId_field_null() {
        CreateUserRequestDto requestDto = new CreateUserRequestDto(null, "테스트", "1234", "01011112222",
            UserType.STUDENT);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }

    @Test
    void createUser_name_field_null() {
        // given
        CreateUserRequestDto requestDto = new CreateUserRequestDto("testUser", null, "1234", "01011112222",
            UserType.STUDENT);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }

    @Test
    void createUser_password_field_null() {
        // given
        CreateUserRequestDto requestDto = new CreateUserRequestDto("testUser", "테스트유저", null, "01011112222",
            UserType.STUDENT);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }

    @Test
    void createUser_phone_field_null() {
        // given
        CreateUserRequestDto requestDto = new CreateUserRequestDto("testUser", "테스트유저", "12345", null,
            UserType.STUDENT);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }

    @Test
    void createUser_userType_field_null() {
        // given
        CreateUserRequestDto requestDto = new CreateUserRequestDto("testUser", "테스트유저", "12345", "01011112222",
            null);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }

    @Test
    void createUser_loginId_field_empty() {
        CreateUserRequestDto requestDto = new CreateUserRequestDto("", "테스트", "1234", "01011112222",
            UserType.STUDENT);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }

    @Test
    void createUser_name_field_empty() {
        CreateUserRequestDto requestDto = new CreateUserRequestDto("", "테스트", "1234", "01011112222",
            UserType.STUDENT);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }

    @Test
    void createUser_password_field_empty() {
        CreateUserRequestDto requestDto = new CreateUserRequestDto("", "테스트", "1234", "01011112222",
            UserType.STUDENT);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }

    @Test
    void createUser_phone_field_empty() {
        CreateUserRequestDto requestDto = new CreateUserRequestDto("", "테스트", "1234", "01011112222",
            UserType.STUDENT);

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(requestDto);
        });

        Assertions.assertThat(exception.getMessage()).isEqualTo("필수값이 없습니다.");
    }


    @Test
    void updateUser() {
    }

    @Test
    void deleteUser() {
    }
}