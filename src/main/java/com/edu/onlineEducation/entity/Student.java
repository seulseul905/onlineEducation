package com.edu.onlineEducation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "edu_user")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "student_user_id")
    private String studentUserId;

    @Column(name = "student_user_password")
    private String studentUserPassword;

    @Column(name = "student_user_name")
    private String studentUserName;

    @Column(name = "student_user_phone")
    private String studentUserPhone;

    @Column(name = "student_user_lecture")
    private String studentUserLecture;

    @Column(name = "student_user_use_yn")
    private boolean studentUserUseYn;

    public void setStudentUserName(String studentUserName) {
        this.studentUserName = studentUserName;
    }

    public void setStudentUserUseYn(boolean studentUserUseYn) {
        this.studentUserUseYn = studentUserUseYn;
    }
}
