package com.LogisticsCompany.dto;

public class OfficeDTO {

    private Long id;
    private String name;
    private String address;
    private CompanyDTO company;

    public OfficeDTO() {
    }

    public OfficeDTO(Long id, String name, String address, CompanyDTO company) {
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

    public CompanyDTO getCompany() {
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

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "OfficeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", company=" + company +
                '}';
    }
}
