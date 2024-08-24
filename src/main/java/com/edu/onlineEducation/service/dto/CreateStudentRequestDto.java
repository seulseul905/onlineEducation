package com.edu.onlineEducation.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStudentRequestDto {

    private String studentUserId;
    private String studentUserName;
    private String studentUserPassword;
    private String studentUserPhone;
    private String studentUserLecture;
}
