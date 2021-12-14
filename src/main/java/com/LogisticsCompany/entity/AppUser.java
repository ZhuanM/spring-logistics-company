package com.LogisticsCompany.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
//@NoArgsConstructor
//@AllArgsConstructor
public class AppUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "username", length = 15, unique = true, nullable = false)
    private String username;

    //@Column(name = "email", length = 45, unique = true, nullable = false)
    private String email;

   // @Column(name="fullName", nullable = false)
    private String fullName;

    //@Column(name = "password", length = 25, nullable = false)
    private String password;

    //0-user, 1-courier, 2-employee
    //@Column(name = "role", nullable = false)
    private int role;


    public AppUser() {
    }

    public AppUser(Long id, String email, String fullName, String password, int role, String username) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.role = role;
        this.username = username;
    }
}