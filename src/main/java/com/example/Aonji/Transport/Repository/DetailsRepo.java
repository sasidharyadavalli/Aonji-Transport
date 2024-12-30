package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepo extends JpaRepository<Details,Long> {
}
