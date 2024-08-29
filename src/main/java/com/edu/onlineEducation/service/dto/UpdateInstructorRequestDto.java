package com.edu.onlineEducation.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateInstructorRequestDto {

    private long instructorId;
    private String instructorUserId;
    private String instructorUserName;
    private String instructorUserPassword;
    private String instructorUserPhone;
    private String instructorUserLecture;
}
