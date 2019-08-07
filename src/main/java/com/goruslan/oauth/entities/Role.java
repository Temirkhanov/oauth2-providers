package com.goruslan.oauth.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Role {

    @Id
    @GeneratedValue
    private long id;

    String name;

    public Role(String name) {
        this.name = name;
    }
}
