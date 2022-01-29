package com.LogisticsCompany.dto;

import com.LogisticsCompany.entity.DeliveryLocation;
import java.time.LocalDate;

public class DeliveryDTO {

    private Long id;
    private String name;
    private CompanyDTO company;
    private AppUserDTO registeredBy;
    private String senderUsername;
    private String recipient;
    private DeliveryLocation status;
    private String recipientAddress;
    private LocalDate sentDate;
    private LocalDate ETA;
    private double weight;
    private double price;

    public DeliveryDTO() {
    }

    public DeliveryDTO(Long id, String name,
                       CompanyDTO company, AppUserDTO registeredBy,
                       String senderUsername, String recipient,
                       DeliveryLocation status, String recipientAddress,
                       LocalDate sentDate, LocalDate ETA,
                       double weight, double price) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.registeredBy = registeredBy;
        this.senderUsername = senderUsername;
        this.recipient = recipient;
        this.status = status;
        this.recipientAddress = recipientAddress;
        this.sentDate = sentDate;
        this.ETA = ETA;
        this.weight = weight;
        this.price = price;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public AppUserDTO getRegisteredBy() {
        return registeredBy;
    }

    public String getSenderUsername() {
        return senderUsername;
    }

    public String getRecipient() {
        return recipient;
    }

    public DeliveryLocation getStatus() {
        return status;
    }

    public String getRecipientAddress() {
        return recipientAddress;
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
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public void setRegisteredBy(AppUserDTO registeredBy) {
        this.registeredBy = registeredBy;
    }

    public void setSenderUsername(String senderUsername) {
        this.senderUsername = senderUsername;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setStatus(DeliveryLocation status) {
        this.status = status;
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
        return "DeliveryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company +
                ", registeredBy=" + registeredBy +
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
}
