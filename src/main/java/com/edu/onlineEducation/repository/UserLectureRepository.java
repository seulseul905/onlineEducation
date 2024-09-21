package com.edu.onlineEducation.repository;

import com.edu.onlineEducation.entity.UserLecture;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLectureRepository extends JpaRepository<UserLecture, Long> {

    Optional<UserLecture> findByEduIdAndClassUseYn(long eduId, boolean classUseYn);

    List<UserLecture> findAllByClassUseYn(boolean classUseYn);

    Optional<UserLecture> findByUserIdAndLectureIdAndClassUseYn(long userId, long lectureId, boolean classUseYn);
}
