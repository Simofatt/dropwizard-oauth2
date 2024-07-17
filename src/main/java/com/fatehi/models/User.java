package com.fatehi.models;

import java.security.Principal;

public class User implements Principal {

public String username;
public String password;
public String name;
    public User(String username) {
        this.username = username;

    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
