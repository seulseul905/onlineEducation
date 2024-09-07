package com.edu.onlineEducation.service.dto.user;

import com.edu.onlineEducation.service.dto.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequestDto {
    private String loginId;
    private String name;
    private String password;
    private String phone;
    private UserType userType;
}
