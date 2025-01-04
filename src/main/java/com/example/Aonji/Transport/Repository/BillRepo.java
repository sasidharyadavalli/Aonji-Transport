package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.Dto.BillResponseDto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepo extends JpaRepository<Bill,Long> {


    List<Bill> findByDate(LocalDate date);

    List<Bill> findByToTownAndReachedFalse(String toTownOrCity);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update bill set reached=not reached where id=?1")
    int toggleReachedById(Long id);

   Optional<Bill> findByLrNo(Long lrNo);

    List<Bill> findByDateAndToTown(LocalDate date, String toTownOrCity);

    List<Bill> findByConsignorAndDate(String consignor, LocalDate date);

    List<Bill> findByConsignor(String consignor);

    List<Bill> findByConsigneeAndDate(String consignee, LocalDate date);

    List<Bill> findByConsignee(String consignee);
}
