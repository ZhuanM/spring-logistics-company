package com.LogisticsCompany.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Delivery> deliveryList;

    public Company() {
    }

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
        this.deliveryList = new ArrayList<>();
    }

    //TO DO
    //list of addresses
    //List of employees
    //list of clients(maybe)


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deliveryList=" + deliveryList +
                '}';
    }
}
