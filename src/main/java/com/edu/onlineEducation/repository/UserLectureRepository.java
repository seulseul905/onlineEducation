package com.edu.onlineEducation.repository;

import com.edu.onlineEducation.entity.Lecture;
import com.edu.onlineEducation.entity.User;
import com.edu.onlineEducation.entity.UserLecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLectureRepository extends JpaRepository<UserLecture, Long> {

    Optional<UserLecture> findByEduIdAndClassUseYn(long eduId, boolean classUseYn);

    List<UserLecture> findAllByClassUseYn(boolean classUseYn);
}
