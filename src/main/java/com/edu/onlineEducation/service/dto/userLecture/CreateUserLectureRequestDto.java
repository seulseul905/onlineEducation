package com.edu.onlineEducation.service.dto.userLecture;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserLectureRequestDto {

    private Long userId;     // PK
    private Long lectureId;  // PK

    public void isValid() {
        if (this.userId == null) {
            throw new IllegalArgumentException("사용자 아이디가 없습니다.");
        }
        if (this.lectureId == null) {
            throw new IllegalArgumentException("강의 아이디가 없습니다.");
        }
    }
}
