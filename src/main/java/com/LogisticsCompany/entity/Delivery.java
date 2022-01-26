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
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id")
    private AppUser sender;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private AppUser recipient;

    @Enumerated(EnumType.STRING)
    @Column(name="delivery_current_location")
    private DeliveryLocation current_location;

    @Column (name = "recipientAdress")
    private String recipientAdress;

    @Column(name = "weight")
    private double weight;

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", sender=" + sender +
                ", recipient=" + recipient +
                ", location=" + current_location +
                ", recipientAdress='" + recipientAdress + '\'' +
                ", weight=" + weight +
                '}';
    }
}
