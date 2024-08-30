package com.edu.onlineEducation.service.dto.lecture;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLectureRequestDto {
    private long lectureId;
    private String lectureName;
    private String lectureInstructorName;
    private String lectureStudentName;
}
