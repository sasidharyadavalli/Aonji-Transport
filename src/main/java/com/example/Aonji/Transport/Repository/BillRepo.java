package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepo extends JpaRepository<Bill,Long> {



}
