package com.edu.onlineEducation.service.dto.lecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLectureRequestDto {
    private String title;
    private String price;
    private String content;
    private long personnel;
}
