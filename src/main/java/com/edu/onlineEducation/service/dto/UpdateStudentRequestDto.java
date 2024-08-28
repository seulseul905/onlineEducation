package com.edu.onlineEducation.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentRequestDto {

    private long studentId;
    private String studentUserId;
    private String studentUserName;
    private String studentUserPassword;
    private String studentUserPhone;
    private String studentUserLecture;
}
