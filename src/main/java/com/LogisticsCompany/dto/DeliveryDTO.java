package com.LogisticsCompany.dto;

import com.LogisticsCompany.entity.DeliveryLocation;
import java.time.LocalDate;

public class DeliveryDTO {

    private Long id;
    private String name;
    private String companySymbol;
    private String registeredBy;
    private String senderUsername;
    private String recipient;
    private DeliveryLocation status;
    private String recipientAddress;
    private String sentDate;
    private String ETA;
    private double weight;
    private double price;

    public DeliveryDTO() {
    }

    public DeliveryDTO(Long id, String name,
                       String companySymbol, String registeredBy,
                       String senderUsername, String recipient,
                       DeliveryLocation status, String recipientAddress,
                       LocalDate sentDate, LocalDate ETA,
                       double weight, double price) {
        this.id = id;
        this.name = name;
        this.companySymbol = companySymbol;
        this.registeredBy = registeredBy;
        this.senderUsername = senderUsername;
        this.recipient = recipient;
        this.status = status;
        this.recipientAddress = recipientAddress;
        this.sentDate = sentDate.toString();
        this.ETA = ETA.toString();
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

    public String getCompanySymbol() {
        return companySymbol;
    }

    public String getRegisteredBy() {
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

    public String getSentDate() {
        return sentDate;
    }

    public String getETA() {
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

    public void setCompanySymbol(String companySymbol) {
        this.companySymbol = companySymbol;
    }

    public void setRegisteredBy(String registeredBy) {
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

    public void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }

    public void setETA(String ETA) {
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
                ", company=" + companySymbol +
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
