package com.LogisticsCompany.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Role() {
    }
}
