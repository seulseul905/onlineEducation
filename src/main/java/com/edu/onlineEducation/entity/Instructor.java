package com.edu.onlineEducation.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "edu_instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    private Long instructorId;

    @Column(name = "instructor_user_id")
    private String instructorUserId;

    @Column(name = "instructor_user_password")
    private String instructorUserPassword;

    @Column(name = "instructor_user_name")
    private String instructorUserName;

    @Column(name = "instructor_user_phone")
    private String instructorUserPhone;

    @Column(name = "instructor_user_lecture")
    private String instructorUserLecture;

    @Column(name = "instructor_user_use_yn")
    private boolean instructorUserUseYn;

}
