package com.accenture.storage.be.entity.user;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private String fullName;
    private boolean isAdmin;
    private String favs;

    public User() {
    }

    public User(@NotEmpty String username, @NotEmpty String password, String fullName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}