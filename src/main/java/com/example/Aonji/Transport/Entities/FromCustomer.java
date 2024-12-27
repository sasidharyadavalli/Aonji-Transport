package com.example.Aonji.Transport.Entities;

import com.example.Aonji.Transport.Entities.Numbers.FromMobile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class FromCustomer {

    public FromCustomer() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;


    public List<FromMobile> getFromMobiles() {
        return fromMobiles;
    }

    @Override
    public String toString() {
        return "FromCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", landmark='" + landmark + '\'' +
                ", cityOrTown='" + cityOrTown + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", bills=" + bills +
                ", fromMobiles=" + fromMobiles +
                '}';
    }

    public void setFromMobiles(List<FromMobile> fromMobiles) {
        this.fromMobiles = fromMobiles;
    }

    public FromCustomer(Long id, String name, String street, String landmark, String cityOrTown, String state, Long pinCode, List<Bill> bills, List<FromMobile> fromMobiles) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.landmark = landmark;
        this.cityOrTown = cityOrTown;
        this.state = state;
        this.pinCode = pinCode;
        this.bills = bills;
        this.fromMobiles = fromMobiles;
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





    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
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

    String street;
    String landmark;
    String cityOrTown;
    String state;
    Long pinCode;
    @OneToMany(mappedBy = "fromCustomer")
    @JsonIgnore
    List<Bill>bills;
    @OneToMany(mappedBy = "fromCustomer")
    @JsonIgnore
    List<FromMobile>fromMobiles;
}
