package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepo extends JpaRepository<Bill,Long> {
}
