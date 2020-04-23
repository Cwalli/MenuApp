package com.company.entity;

import java.util.Date;

public class Institution {
    private int id;
    private String instName;
    private String instType;
    private String openingHours;
    private String phone;
    private String address;
    private Date createdAt;
    private Date updatedAt;

    public Institution(int id, String instName, String instType, String openingHours, String phone, String address, Date createdAt, Date updatedAt) {
        this.id = id;
        this.instName = instName;
        this.instType = instType;
        this.openingHours = openingHours;
        this.phone = phone;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Institution( String instName, String instType, String openingHours, String phone, String address) {
        this.instName = instName;
        this.instType = instType;
        this.openingHours = openingHours;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName;
    }

    public String getInstType() {
        return instType;
    }

    public void setInstType(String instType) {
        this.instType = instType;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static Institution createItemForSaving( String inst_name, String inst_type, String opening_hours, String phone, String address) {
        return new Institution( inst_name, inst_type, opening_hours, phone, address);
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", instName='" + instName + '\'' +
                ", intType='" + instType + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
