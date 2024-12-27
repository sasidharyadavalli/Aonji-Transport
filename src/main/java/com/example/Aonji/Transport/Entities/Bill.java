package com.example.Aonji.Transport.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
public class Bill {
 public Bill() {
 }

 public Bill(Long id, Long lr_no, String to_townOrCity, int no_of_parcels, Date date, String parcel_description, ToCustomer toCustomer, Agent agent, FromCustomer fromCustomer, int cost) {
  this.id = id;
  this.lr_no = lr_no;
  To_townOrCity = to_townOrCity;
  this.no_of_parcels = no_of_parcels;
  this.date = date;
  this.parcel_description = parcel_description;
  this.toCustomer = toCustomer;
  this.agent = agent;
  this.fromCustomer = fromCustomer;
  this.cost = cost;
 }

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   @Column(nullable = false)
    Long lr_no;

 public Long getId() {
  return id;
 }

 @Override
 public String toString() {
  return "Bill{" +
          "id=" + id +
          ", lr_no=" + lr_no +
          ", To_townOrCity='" + To_townOrCity + '\'' +
          ", no_of_parcels=" + no_of_parcels +
          ", date=" + date +
          ", parcel_description='" + parcel_description + '\'' +
          ", toCustomer=" + toCustomer +
          ", agent=" + agent +
          ", fromCustomer=" + fromCustomer +
          ", cost=" + cost +
          '}';
 }

 public void setId(Long id) {
  this.id = id;
 }

 public Long getLr_no() {
  return lr_no;
 }

 public void setLr_no(Long lr_no) {
  this.lr_no = lr_no;
 }

 public String getTo_townOrCity() {
  return To_townOrCity;
 }

 public void setTo_townOrCity(String to_townOrCity) {
  To_townOrCity = to_townOrCity;
 }

 public int getNo_of_parcels() {
  return no_of_parcels;
 }

 public void setNo_of_parcels(int no_of_parcels) {
  this.no_of_parcels = no_of_parcels;
 }

 public Date getDate() {
  return date;
 }

 public void setDate(Date date) {
  this.date = date;
 }

 public String getParcel_description() {
  return parcel_description;
 }

 public void setParcel_description(String parcel_description) {
  this.parcel_description = parcel_description;
 }

 public ToCustomer getToCustomer() {
  return toCustomer;
 }

 public void setToCustomer(ToCustomer toCustomer) {
  this.toCustomer = toCustomer;
 }

 public Agent getAgent() {
  return agent;
 }

 public void setAgent(Agent agent) {
  this.agent = agent;
 }

 public FromCustomer getFromCustomer() {
  return fromCustomer;
 }

 public void setFromCustomer(FromCustomer fromCustomer) {
  this.fromCustomer = fromCustomer;
 }

 public int getCost() {
  return cost;
 }

 public void setCost(int cost) {
  this.cost = cost;
 }

 @Column(nullable = false)
    String To_townOrCity;
    int no_of_parcels;
    @Column(nullable = false)
    Date date;
    String parcel_description;
    @ManyToOne
     @JoinColumn(name = "to_customer_id")
    ToCustomer toCustomer;
    @ManyToOne
    @JoinColumn(name = "agent_id")
    Agent agent;
    @ManyToOne
    @JoinColumn(name = "from_customer_id")
    FromCustomer fromCustomer;
    @Column(nullable = false)
    int cost;
}
