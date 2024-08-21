package com.example.jwt.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "teacher")
public class Teacher {
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
