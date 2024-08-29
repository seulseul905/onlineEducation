package com.edu.onlineEducation.repository;

import com.edu.onlineEducation.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorUserRepository extends JpaRepository<Instructor, Long> {

    List<Instructor> findAllByInstructorUserUseYn(boolean instructorUserUseYn);
}
