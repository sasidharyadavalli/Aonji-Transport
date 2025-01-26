package com.example.Aonji.Transport.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Agent {

    public Agent() {
    }

    public Agent(Long id, String name, Long mobile, String street, String landmark, String town, String state, Long pinCode, List<Bill> bills) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.street = street;
        this.landmark = landmark;
        this.town = town;
        this.state = state;
        this.pinCode = pinCode;
        this.bills = bills;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mobile=" + mobile +
                ", street='" + street + '\'' +
                ", landmark='" + landmark + '\'' +
                ", town='" + town + '\'' +
                ", state='" + state + '\'' +
                ", pinCode=" + pinCode +
                ", bills=" + bills +
                '}';
    }

   private String name;
   private Long mobile;

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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
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
   @Column(unique = true,nullable = false,name = "city_or_town")
   private String town;
   private String state;
   private Long pinCode;
    @OneToMany(mappedBy = "agent")
     @JsonIgnore
   private List<Bill>bills;
    @OneToMany(mappedBy = "agent")
    @JsonIgnore
    private List<Accounts>accounts;
}
