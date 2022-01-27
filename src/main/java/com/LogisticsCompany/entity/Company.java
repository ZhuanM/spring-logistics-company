package com.LogisticsCompany.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Office> officeList;

    public Company() {
    }

    public Company(Long id, String name) {
        this.id = id;
        this.name = name;
        this.deliveryList = new ArrayList<>();
        this.officeList = new ArrayList<>();
    }

    //TO DO
    //List of employees
    //list of clients(maybe)

    public void addOffice(Office office) {
        if(!this.officeList.contains(office)) {
            this.officeList.add(office);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public List<Office> getOfficeList() {
        return officeList;
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
