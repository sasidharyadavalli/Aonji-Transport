package com.example.Aonji.Transport.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long mobile;
    String street;
    String landmark;
    String cityOrTown;
    String state;
    Long pinCode;
    @OneToMany(mappedBy = "agent")
    List<Bill>bills;
}
