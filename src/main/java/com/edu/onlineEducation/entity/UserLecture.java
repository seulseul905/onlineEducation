package com.edu.onlineEducation.entity;

import com.edu.onlineEducation.service.dto.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "edu_user_lecture")
public class UserLecture {

    @ManyToOne
    @JoinColumn(name = "id")
    private User userId;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lectureId;

    @Column(name = "instructor_name")
    private String instructorName;

    @Column(name = "class_use_yn")
    private boolean classUseYn;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}


