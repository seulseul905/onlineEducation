package com.edu.onlineEducation.service.dto.userLecture;

import com.edu.onlineEducation.entity.Lecture;
import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.service.dto.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserLectureRequestDto {

    private User id;
    private Lecture lectureId;
    private String instructorName;
}
