package com.edu.onlineEducation.service.dto.user;

import com.edu.onlineEducation.service.dto.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {

    private long id;
    private String name;
    private String password;
    private String phone;
    private UserType userType;
    private boolean useYn;
}
