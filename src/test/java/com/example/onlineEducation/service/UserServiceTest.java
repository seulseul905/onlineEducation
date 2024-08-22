package com.example.onlineEducation.service;

import com.example.onlineEducation.entity.User;
import com.example.onlineEducation.repository.UserRepository;
import com.example.onlineEducation.service.dto.CreateUserRequestDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class UserServiceTest {

    @InjectMocks
    public UserService userService;
    @Mock
    public UserRepository userRepository;

    @Test
    public void createUserTest() {
        //given
        //상황을 주는것.
        CreateUserRequestDto dto = new CreateUserRequestDto("testUser", "테스트유저");

        //when
        //언제동작하나?
        User user = userService.createUser(dto);

        //then
        assertEqual(user.getUserId(), dto.getUserId());


    }

    @Test
    public void createUserTest() {
        //given
        //상황을 주는것.
        CreateUserRequestDto dto = new CreateUserRequestDto();
        dto.setUserId("testUser");

        //when
        //언제동작하나?
        User user = userService.createUser(dto);

        //then
        assertThrow(IllegalArgumentException);
    }
}