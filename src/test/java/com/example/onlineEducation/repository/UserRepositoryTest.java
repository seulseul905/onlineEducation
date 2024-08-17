package com.example.onlineEducation.repository;

import com.example.onlineEducation.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void jpaSave(){
        for(long i = 0L; i < 10; i++){
            User user = User.builder().name("Hi" + i).build();
            System.out.println("User : " + user.toString());
            userRepository.save(user);
        }
    }

    @Test
    public void jpaFind(){
        Optional<User> user = userRepository.findById(3L);
        System.out.println(user.isPresent() ? user.get().toString() : "Nothing");
    }

    @Test
    public void jpaDelete(){
        userRepository.delete(User.builder().name("Hi4").id(5L).build());
    }


}