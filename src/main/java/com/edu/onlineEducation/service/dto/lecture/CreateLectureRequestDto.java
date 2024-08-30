package com.edu.onlineEducation.service.dto.lecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLectureRequestDto {
    private String lectureName;
    private String lectureInstructorName;
    private String lectureStudentName;
    private String lectureUseYn;
}
