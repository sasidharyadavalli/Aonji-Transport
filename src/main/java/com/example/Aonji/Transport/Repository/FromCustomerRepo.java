package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.FromCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FromCustomerRepo extends JpaRepository<FromCustomer,Long> {
    FromCustomer findByName(String name);
}
