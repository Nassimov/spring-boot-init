package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "\"user\"")
public class User {

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // This will auto-increment the primary key
    private Long id;

    @Getter
    @Setter
    @NotEmpty
    private String username;
    @Getter
    @Setter
    private Integer age;

    public User() {

    }
}
