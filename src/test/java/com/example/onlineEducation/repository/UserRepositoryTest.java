package com.example.onlineEducation.repository;

import com.example.onlineEducation.entity.User;
import jakarta.annotation.PostConstruct;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void jpaSave() {
        for (long i = 0L; i < 10; i++) {
            User user = User.builder().userId("test").userName("Hi" + i).build();
            System.out.println("User : " + user.toString());
            userRepository.save(user);
        }
    }

    @Test
    public void jpaFind() {
        Optional<User> user = userRepository.findById(1L);
        System.out.println(user.isPresent() ? user.get().toString() : "Nothing");
    }

    @Test
    public void jpaDelete() {
        userRepository.delete(User.builder().id(1L).userName("Hi4").userId("test").build());
    }

}