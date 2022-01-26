package com.LogisticsCompany.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class Delivery {

    @Transient
    private transient long ORDER_ID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "sender_id")
    private AppUser sender;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="user_id")
//    private AppUser recipient;
    @Column(name = "recipient")
    private String recipient;

    @Enumerated(EnumType.STRING)
    @Column(name="delivery_current_location")
    private DeliveryLocation current_location;

    @Column (name = "recipientAddress")
    private String recipientAddress;

    @Column(name = "weight")
    private double weight;

    public Delivery() {
    }

    public Delivery(Long id, Company company, AppUser sender,
                    String recipient, DeliveryLocation current_location,
                    String recipientAddress, double weight) {
        this.setORDER_ID();
        this.id = id;
        this.name = "d_" + sender.getUsername() + "_" + this.getORDER_ID();
        this.company = company;
        this.sender = sender;
        this.recipient = recipient;
        this.current_location = current_location;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
    }

    //Getters

    public long getORDER_ID() {
        return ORDER_ID;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public AppUser getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public DeliveryLocation getCurrent_location() {
        return current_location;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public double getWeight() {
        return weight;
    }

    //Setters

    public void setORDER_ID() {
        this.ORDER_ID = this.getORDER_ID() + 1;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setSender(AppUser sender) {
        this.sender = sender;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setCurrent_location(DeliveryLocation current_location) {
        this.current_location = current_location;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", name=" + name +
                //", sender=" + sender +
                ", recipient=" + recipient +
                ", location=" + current_location +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", weight=" + weight +
                '}';
    }
}
