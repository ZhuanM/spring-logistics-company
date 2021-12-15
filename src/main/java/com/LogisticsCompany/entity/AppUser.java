package com.LogisticsCompany.entity;

import lombok.*;
import org.hibernate.annotations.Target;

import javax.persistence.*;

@Entity
@Table(name = "users")
//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class AppUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @Column(name = "username", length = 15, unique = true, nullable = false)
    private String username;

    //@Column(name = "email", length = 45, unique = true, nullable = false)
    private String email;

    //@Column(name="fullName", nullable = false)
    private String fullName;

    //@Column(name = "password", length = 25, nullable = false)
    private String password;

    private String role;

    @Column(name = "role", nullable = false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public AppUser() {
    }

    public AppUser(Long id, String email, String fullName, String password, String role, String username) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.username = username;
    }

    public AppUser(Long id, String email, String fullName, String password, String username) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.role = "";
        this.username = username;
    }
}