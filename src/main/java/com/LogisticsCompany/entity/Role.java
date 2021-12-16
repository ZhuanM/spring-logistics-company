package com.LogisticsCompany.entity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;

@Entity
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
