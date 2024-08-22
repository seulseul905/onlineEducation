package com.example.onlineEducation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "edu_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "use_yn", nullable = false)
    private boolean useYn;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUseYn(boolean useYn) {
        this.useYn = useYn;
    }
}
