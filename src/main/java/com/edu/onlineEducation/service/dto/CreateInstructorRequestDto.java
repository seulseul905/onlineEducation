package com.edu.onlineEducation.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequestDto {
    private String instructorUserId;
    private String instructorUserName;
    private String instructorUserPassword;
    private String instructorUserPhone;
    private String instructorUserLecture;
}
