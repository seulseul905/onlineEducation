package com.edu.onlineEducation.service.dto.lecture;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLectureRequestDto {
    private long lectureId;
    private String title;
    private String price;
    private String content;
    private long personnel;
    private boolean lectureUseYn;
}
