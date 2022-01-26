package com.LogisticsCompany.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@Setter
@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

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

    @Column (name = "recipientAdress")
    private String recipientAddress;

    @Column(name = "weight")
    private double weight;

    public Delivery() {
    }

    public Delivery(Long id, AppUser sender, String recipient, DeliveryLocation current_location, String recipientAddress, double weight) {
        this.id = id;
        this.sender = sender;
        this.recipient = recipient;
        this.current_location = current_location;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", location=" + current_location +
                ", recipientAdress='" + recipientAddress + '\'' +
                ", weight=" + weight +
                '}';
    }
}
