package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Accounts, Long> {
    @Query(nativeQuery = true,value = "select * from accounts a where MONTH(a.date)= :month and YEAR(a.date)= :year AND a.to= :to ")
    List<Accounts> findByMonthYearAndTo(@Param("month")int month, @Param("year")int year, @Param("to")String to);
}
