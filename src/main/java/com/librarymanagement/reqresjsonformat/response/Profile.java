package com.librarymanagement.reqresjsonformat.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Profile {
    private Long id;
    private String username;
    private List<String> roles;

    public Profile(Long id, String username, List<String>roles) {
        this.id = id;
        this.username = username;
        this.roles = new ArrayList<>();
        for (String s : roles){
            if(s.equals("ROLE_USER")) this.roles.add("user");
            else this.roles.add("admin");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
