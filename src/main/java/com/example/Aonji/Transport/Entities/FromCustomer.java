package com.example.Aonji.Transport.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class FromCustomer {

    public FromCustomer() {
    }

    public FromCustomer(Long id, String name,Long mobile2 ,Long mobile, String street, String landmark, String cityOrTown, String state, Long pinCode, List<Bill> bills) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.street = street;
        this.landmark = landmark;
        this.cityOrTown = cityOrTown;
        this.state = state;
        this.pinCode = pinCode;
        this.bills = bills;
        this.mobile2=mobile2;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private   Long id;
   private String name;


    @Override
    public String toString() {
        return "FromCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile=" + mobile +
                ", mobile2=" + mobile2 +
                ", street='" + street + '\'' +
                ", landmark='" + landmark + '\'' +
                ", cityOrTown='" + cityOrTown + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", bills=" + bills +
                '}';
    }

   private Long mobile;

    public Long getMobile2() {
        return mobile2;
    }

    public void setMobile2(Long mobile2) {
        this.mobile2 = mobile2;
    }

   private Long mobile2;

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

   private String street;
   private String landmark;
   private String cityOrTown;
   private String state;
   private Long pinCode;
    @OneToMany(mappedBy = "fromCustomer")
    @JsonIgnore
   private List<Bill>bills;
}
