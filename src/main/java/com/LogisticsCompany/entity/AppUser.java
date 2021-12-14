package com.LogisticsCompany.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 15, unique = true, nullable = false)
    private String username;

    @Column(name = "email", length = 45, unique = true, nullable = false)
    private String email;

    @Column(name="fullName", nullable = false)
    private String fullName;

    @Column(name = "password", length = 25, nullable = false)
    private String password;

    //0-user, 1-courier, 2-employee
    @Column(name = "role", nullable = false)
    private short role;
}