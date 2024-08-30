package com.edu.onlineEducation.repository;

import com.edu.onlineEducation.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    List<Lecture> findAllByLectureUseYn(boolean lectureUseYn);
}
