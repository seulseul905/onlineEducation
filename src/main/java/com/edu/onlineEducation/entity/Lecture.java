package com.edu.onlineEducation.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "edu_lecture")
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lecture_id")
    private Long lectureId;

    @Column(name = "lecture_name")
    private String lectureName;

    @Column(name = "lecture_instructor_name")
    private String lectureInstructorName;

    @Column(name = "lecture_student_name")
    private String lectureStudentName;

    @Column(name = "lecture_use_yn")
    private boolean lectureUseYn;
}
