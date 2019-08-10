package com.goruslan.oauth.entities;

import lombok.Getter;
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

    private String login;

//    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Role> roles;

    public User(String login, String password) {
        this.login = login;
    }




}
