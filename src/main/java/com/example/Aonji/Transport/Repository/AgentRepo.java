package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepo extends JpaRepository<Agent,Long> {
    Optional<Agent> findByTown(String town);

    boolean existsByTown(String town);
}
