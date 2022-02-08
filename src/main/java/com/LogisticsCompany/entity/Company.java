package com.LogisticsCompany.entity;


import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "company")
//@JsonIgnoreProperties({"deliveryList", "officeList", "hibernateLazyInitializer", "handler"})
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "symbol", unique = true, nullable = false)
    private String symbol;

    @OneToMany(mappedBy = "company")
    private List<Delivery> deliveryList;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Office> officeList;

    public Company() {
    }

    public Company(Long id, String name, String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
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

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public List<Office> getOfficeList() {
        return officeList;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    public void setOfficeList(List<Office> officeList) {
        this.officeList = officeList;
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
