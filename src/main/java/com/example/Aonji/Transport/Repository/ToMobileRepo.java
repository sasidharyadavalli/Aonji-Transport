package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.Numbers.ToMobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToMobileRepo extends JpaRepository<ToMobile,Long> {
}
