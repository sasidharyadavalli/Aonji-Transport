package com.example.Aonji.Transport.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private   Long id;
   private Integer no_of_parcels;
   private String of_type;
   private String destination;
   private Double cost;
   private Long mobile;

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", no_of_parcels=" + no_of_parcels +
                ", of_type='" + of_type + '\'' +
                ", destination='" + destination + '\'' +
                ", cost=" + cost +
                ", mobile=" + mobile +
                ", bill=" + bill +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNo_of_parcels() {
        return no_of_parcels;
    }

    public void setNo_of_parcels(Integer no_of_parcels) {
        this.no_of_parcels = no_of_parcels;
    }

    public String getOf_type() {
        return of_type;
    }

    public void setOf_type(String of_type) {
        this.of_type = of_type;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Details() {
    }

    public Details(Long id, Integer no_of_parcels, String of_type, String destination, Double cost, Long mobile, Bill bill) {
        this.id = id;
        this.no_of_parcels = no_of_parcels;
        this.of_type = of_type;
        this.destination = destination;
        this.cost = cost;
        this.mobile = mobile;
        this.bill = bill;
    }

    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonBackReference
   private Bill bill;
}
