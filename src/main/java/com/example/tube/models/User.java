package com.example.tube.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastName;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<Channel> channels = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserWatchedVideos> watched = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Reply> replies = new HashSet<>();
}
