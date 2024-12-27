package com.example.Aonji.Transport.Entities.Numbers;

import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.FromCustomer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

@Entity
public class FromMobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
Long mobile;
@OneToMany(mappedBy = "fromMobile")
@JsonIgnore
List<Bill>bills;

    public FromMobile() {
    }

    @Override
    public String toString() {
        return "FromMobile{" +
                "id=" + id +
                ", mobile=" + mobile +
                ", bills=" + bills +
                ", fromCustomer=" + fromCustomer +
                '}';
    }

    public FromMobile(Long id, Long mobile, List<Bill> bills, FromCustomer fromCustomer) {
        this.id = id;
        this.mobile = mobile;
        this.bills = bills;
        this.fromCustomer = fromCustomer;
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

    public FromCustomer getFromCustomer() {
        return fromCustomer;
    }

    public void setFromCustomer(FromCustomer fromCustomer) {
        this.fromCustomer = fromCustomer;
    }

    @ManyToOne
@JoinColumn(name = "fromMobiles")
FromCustomer fromCustomer;

}
