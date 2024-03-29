package com.LogisticsCompany.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "offices")
//@JsonIgnoreProperties({"company", "hibernateLazyInitializer", "handler"})
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_name")
    private String name;

    @Column(name = "address", unique = true, nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Office() {
    }

    public Office(Long id, String name, String address, Company company) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.company = company;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
