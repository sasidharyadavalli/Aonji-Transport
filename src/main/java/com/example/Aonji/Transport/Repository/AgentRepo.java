package com.example.Aonji.Transport.Repository;

import com.example.Aonji.Transport.Entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepo extends JpaRepository<Agent,Long> {
}
