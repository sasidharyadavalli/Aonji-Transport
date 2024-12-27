package com.example.Aonji.Transport.Entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bill {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
   @Column(nullable = false)
    Long lr_no;
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
