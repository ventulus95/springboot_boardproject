package com.ventulus95.boardproject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table
public class User implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private LocalDateTime createdTime;

    @Column
    private LocalDateTime updateTime;

    @Builder
    public User(String name, String password, String email, LocalDateTime createdTime, LocalDateTime updateTime) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.createdTime = createdTime;
        this.updateTime = updateTime;
    }
}
