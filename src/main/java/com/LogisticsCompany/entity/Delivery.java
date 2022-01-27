package com.LogisticsCompany.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "delivery")
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class Delivery implements Comparable<Delivery>{

    @Transient
    private static transient long ORDER_ID = 1;

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
    @JoinColumn(name= "registered_by")
    private AppUser registeredBy;

    @Column(name = "sender")
    private String senderUsername;

    @Column(name = "recipient")
    private String recipient;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private DeliveryLocation status;

    @Column (name = "recipientAddress")
    private String recipientAddress;

    @Column(name = "date_sent")
    private LocalDate sentDate;

    @Column(name = "arrival_date")
    private LocalDate ETA;

    @Column(name = "weight")
    private double weight;

    @Column(name = "price")
    private double price;

    public Delivery() {
    }

    public Delivery(Long id, Company company, AppUser registeredBy,
                    String senderUsername,
                    String recipient, DeliveryLocation current_location,
                    String recipientAddress,
                    LocalDate sentDate, LocalDate ETA,
                    double weight, double price) {
        this.setORDER_ID();
        this.id = id;
        this.name = "d_" + senderUsername + "_" + this.getORDER_ID();
        this.company = company;
        this.registeredBy = registeredBy;
        this.senderUsername = senderUsername;
        this.recipient = recipient;
        this.status = current_location;
        this.recipientAddress = recipientAddress;
        this.sentDate = sentDate;
        this.ETA = ETA;
        this.weight = weight;
        this.price = price;
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

    public AppUser getRegisteredBy() {
        return registeredBy;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getRecipient() {
        return recipient;
    }

    public DeliveryLocation getCurrent_location() {
        return status;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public DeliveryLocation getStatus() {
        return status;
    }

    public LocalDate getSentDate() {
        return sentDate;
    }

    public LocalDate getETA() {
        return ETA;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    //Setters

    public void setORDER_ID() {
        ORDER_ID = this.getORDER_ID() + 1;
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

    public void setRegisteredBy(AppUser registeredBy) {
        this.registeredBy = registeredBy;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setStatus(DeliveryLocation current_location) {
        this.status = current_location;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public void setSentDate(LocalDate sentDate) {
        this.sentDate = sentDate;
    }

    public void setETA(LocalDate ETA) {
        this.ETA = ETA;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", senderUsername='" + senderUsername + '\'' +
                ", recipient='" + recipient + '\'' +
                ", status=" + status +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", sentDate=" + sentDate +
                ", ETA=" + ETA +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Delivery d) {
        return this.getId().compareTo(d.getId());
    }
}
