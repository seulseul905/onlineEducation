package com.edu.onlineEducation.service;

import com.edu.onlineEducation.repository.UserRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class UserServiceTest {

    @InjectMocks
    public UserService userService;
    @Mock
    public UserRepository userRepository;

//    @Test
//    public void createUserTest() {
//        //given
//        //상황을 주는것.
//        CreateStudentRequestDto dto = new CreateStudentRequestDto();
//
//        //when
//        //언제동작하나?
//        Student user = userService.createUser(dto);
//
//        //then
//        assertEqual(user.getStudentUserId(), dto.getStudentUserId());
//
//
//    }
//
//    @Test
//    public void createUserTest() {
//        //given
//        //상황을 주는것.
//        CreateStudentRequestDto dto = new CreateStudentRequestDto();
//        dto.setStudentUserId("testUser");
//
//        //when
//        //언제동작하나?
//        Student user = userService.createUser(dto);
//
//        //then
//        assertThrow(IllegalArgumentException);
//    }
}