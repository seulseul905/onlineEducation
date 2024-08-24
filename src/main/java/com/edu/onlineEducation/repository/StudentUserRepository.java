package com.edu.onlineEducation.repository;

import com.edu.onlineEducation.entity.Student;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentUserRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByStudentUserUseYn(boolean studentUserUseYn);
}
