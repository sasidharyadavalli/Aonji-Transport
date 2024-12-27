package com.example.Aonji.Transport.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class ToCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long mobile;
    String Street;

    public ToCustomer() {
    }

    public ToCustomer(Long id, String name, Long mobile, String street, String landMark, String cityOrTown, String state, Long pinCode, List<Bill> bills) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        Street = street;
        LandMark = landMark;
        this.cityOrTown = cityOrTown;
        this.state = state;
        this.pinCode = pinCode;
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "ToCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile=" + mobile +
                ", Street='" + Street + '\'' +
                ", LandMark='" + LandMark + '\'' +
                ", cityOrTown='" + cityOrTown + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", bills=" + bills +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getLandMark() {
        return LandMark;
    }

    public void setLandMark(String landMark) {
        LandMark = landMark;
    }

    public String getCityOrTown() {
        return cityOrTown;
    }

    public void setCityOrTown(String cityOrTown) {
        this.cityOrTown = cityOrTown;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    String LandMark;
    String cityOrTown;
    String state;
    Long pinCode;
    @OneToMany(mappedBy = "toCustomer")
    List<Bill> bills;

}
