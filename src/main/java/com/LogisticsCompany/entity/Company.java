package com.LogisticsCompany.entity;


import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    //TO DO
    //list of addresses
    //List of employees
    //list of clients(maybe)
}
