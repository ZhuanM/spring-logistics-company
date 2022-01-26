package com.LogisticsCompany.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
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

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    //or @Embedded private Role role;
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender", cascade = CascadeType.ALL)
    private Set<Delivery> deliveries = new HashSet<Delivery>();

    public AppUser() {
    }

    public AppUser(Long id, String email, String fullName, String password, RoleType role, String username) {
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
        this.role = RoleType.USER;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}