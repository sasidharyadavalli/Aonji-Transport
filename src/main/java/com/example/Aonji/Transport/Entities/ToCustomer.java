package com.example.Aonji.Transport.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ToCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long mobile;
    String Street;
    String LandMark;
    String cityOrTown;
    String state;
    Long pinCode;
    @OneToMany(mappedBy = "toCustomer")
    List<Bill> bills;

}
