package com.example.Aonji.Transport.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class FromCustomer {

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
    @OneToMany(mappedBy = "fromCustomer")
    List<Bill>bills;
}
