package com.edu.onlineEducation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDateTime;

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

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private String price;

    @Column(name = "content")
    private String content;

    @Column(name = "personnel")
    private long personnel;

    @Column(name = "lecture_use_yn")
    private boolean lectureUseYn;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
