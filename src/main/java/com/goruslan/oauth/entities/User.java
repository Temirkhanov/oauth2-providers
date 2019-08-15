package com.goruslan.oauth.entities;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    private String username;

    private String bio;

    private String url;

    private String avatar;


    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;

    public User(String username, String bio, String url, String avatar) {
        this.username = username;
        this.bio = bio;
        this.url = url;
        this.avatar = avatar;
    }
}
