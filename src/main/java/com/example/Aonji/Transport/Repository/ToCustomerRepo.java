package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.ToCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToCustomerRepo extends JpaRepository<ToCustomer,Long> {
   // ToCustomer findByNameAndMobile(String name,Long mobile);

    ToCustomer findByName(String name);
}
