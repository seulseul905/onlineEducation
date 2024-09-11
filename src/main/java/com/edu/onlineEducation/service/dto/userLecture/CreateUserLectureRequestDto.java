package com.edu.onlineEducation.service.dto.userLecture;

import com.edu.onlineEducation.entity.Lecture;
import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.service.dto.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserLectureRequestDto {
    private User id;
    private Lecture lectureId;
    private String instructorName;
}
