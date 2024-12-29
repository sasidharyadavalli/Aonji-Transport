package com.example.Aonji.Transport.Entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Bill {
 public Bill() {
 }

 public Bill(Long id, Long lr_no, Long to_mobile, Long from_mobile, String to_townOrCity, int no_of_parcels, Date date, String parcel_description, ToCustomer toCustomer, Agent agent, FromCustomer fromCustomer, Double cost, Boolean paid, String consignor, String consignee, String from_TownOrCity) {
  this.id = id;
  this.lr_no = lr_no;
  this.to_mobile = to_mobile;
  this.from_mobile = from_mobile;
  To_townOrCity = to_townOrCity;
  this.no_of_parcels = no_of_parcels;
  this.date = date;
  this.parcel_description = parcel_description;
  this.toCustomer = toCustomer;
  this.agent = agent;
  this.fromCustomer = fromCustomer;
  this.cost = cost;
  this.paid = paid;
  this.consignor = consignor;
  this.consignee = consignee;
  From_TownOrCity = from_TownOrCity;
 }

 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   @Column(nullable = false)
    Long lr_no;
   Long to_mobile;

 public Long getTo_mobile() {
  return to_mobile;
 }

 public void setTo_mobile(Long to_mobile) {
  this.to_mobile = to_mobile;
 }

 public Long getFrom_mobile() {
  return from_mobile;
 }

 public void setFrom_mobile(Long from_mobile) {
  this.from_mobile = from_mobile;
 }

 Long from_mobile;

 public Long getId() {
  return id;
 }

 @Override
 public String toString() {
  return "Bill{" +
          "id=" + id +
          ", lr_no=" + lr_no +
          ", to_mobile=" + to_mobile +
          ", from_mobile=" + from_mobile +
          ", To_townOrCity='" + To_townOrCity + '\'' +
          ", no_of_parcels=" + no_of_parcels +
          ", date=" + date +
          ", parcel_description='" + parcel_description + '\'' +
          ", toCustomer=" + toCustomer +
          ", agent=" + agent +
          ", fromCustomer=" + fromCustomer +
          ", cost=" + cost +
          ", paid=" + paid +
          ", consignor='" + consignor + '\'' +
          ", consignee='" + consignee + '\'' +
          ", From_TownOrCity='" + From_TownOrCity + '\'' +
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

 public boolean isPaid() {
  return paid;
 }

 public void setPaid(boolean paid) {
  this.paid = paid;
 }

 public String getConsignor() {
  return consignor;
 }

 public void setConsignor(String consignor) {
  this.consignor = consignor;
 }

 public String getConsignee() {
  return consignee;
 }

 public void setConsignee(String consignee) {
  this.consignee = consignee;
 }

 public String getFrom_TownOrCity() {
  return From_TownOrCity;
 }

 public void setFrom_TownOrCity(String from_TownOrCity) {
  From_TownOrCity = from_TownOrCity;
 }

 public FromCustomer getFromCustomer() {
  return fromCustomer;
 }

 public void setFromCustomer(FromCustomer fromCustomer) {
  this.fromCustomer = fromCustomer;
 }

 public Double getCost() {
  return cost;
 }

 public void setCost(Double cost) {
  this.cost = cost;
 }

 @Column(nullable = false)
    String To_townOrCity;
    Integer no_of_parcels;
    @Column(nullable = false)
    Date date;
    String parcel_description;
    @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "to_customer_id")
    ToCustomer toCustomer;
    @ManyToOne
    @JoinColumn(name = "agent_id")
    Agent agent;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "from_customer_id")
    FromCustomer fromCustomer;
    @Column(nullable = false)
    Double cost;
    Boolean paid;

    String consignor;
    String consignee;
    String From_TownOrCity="proddatur";
}
