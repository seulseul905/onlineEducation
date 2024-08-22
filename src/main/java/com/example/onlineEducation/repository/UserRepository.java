package com.example.onlineEducation.repository;

import com.example.onlineEducation.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUseYn(boolean useYn);
}
