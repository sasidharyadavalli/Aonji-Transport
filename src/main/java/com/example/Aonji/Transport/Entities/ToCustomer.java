package com.example.Aonji.Transport.Entities;

import com.example.Aonji.Transport.Entities.Numbers.ToMobile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class ToCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String Street;

    public ToCustomer() {
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
    @JsonIgnore
    List<Bill> bills;

    @Override
    public String toString() {
        return "ToCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Street='" + Street + '\'' +
                ", LandMark='" + LandMark + '\'' +
                ", cityOrTown='" + cityOrTown + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", bills=" + bills +
                ", toMobiles=" + toMobiles +
                '}';
    }

    public List<ToMobile> getToMobiles() {
        return toMobiles;
    }

    public void setToMobiles(List<ToMobile> toMobiles) {
        this.toMobiles = toMobiles;
    }

    public ToCustomer(Long id, String name, String street, String landMark, String cityOrTown, String state, Long pinCode, List<Bill> bills, List<ToMobile> toMobiles) {
        this.id = id;
        this.name = name;
        Street = street;
        LandMark = landMark;
        this.cityOrTown = cityOrTown;
        this.state = state;
        this.pinCode = pinCode;
        this.bills = bills;
        this.toMobiles = toMobiles;
    }

    @OneToMany(mappedBy = "toCustomer")
     @JsonIgnore
      List<ToMobile>toMobiles;
}
