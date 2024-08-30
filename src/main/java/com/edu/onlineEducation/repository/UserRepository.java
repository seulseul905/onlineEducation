package com.edu.onlineEducation.repository;

import com.edu.onlineEducation.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByIdAndUseYn(long id, boolean useYn);

    List<User> findAllByUseYn(boolean useYn);
}
