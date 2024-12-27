package com.example.Aonji.Transport.Entities.Numbers;

import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.ToCustomer;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ToMobile {
  @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   Long mobile;

 public ToMobile(Long id, Long mobile, List<Bill> bills, ToCustomer toCustomer) {
  this.id = id;
  this.mobile = mobile;
  this.bills = bills;
  this.toCustomer = toCustomer;
 }

 public ToMobile() {
 }

 @Override
 public String toString() {
  return "ToMobile{" +
          "id=" + id +
          ", mobile=" + mobile +
          ", bills=" + bills +
          ", toCustomer=" + toCustomer +
          '}';
 }

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public Long getMobile() {
  return mobile;
 }

 public void setMobile(Long mobile) {
  this.mobile = mobile;
 }

 public List<Bill> getBills() {
  return bills;
 }

 public void setBills(List<Bill> bills) {
  this.bills = bills;
 }

 public ToCustomer getToCustomer() {
  return toCustomer;
 }

 public void setToCustomer(ToCustomer toCustomer) {
  this.toCustomer = toCustomer;
 }

 @OneToMany(mappedBy = "toMobile")
   List<Bill>bills;

   @ManyToOne
    @JoinColumn(name = "to_customer_id")
   ToCustomer toCustomer;
}
