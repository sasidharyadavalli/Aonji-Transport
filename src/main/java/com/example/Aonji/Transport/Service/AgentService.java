package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Repository.AgentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {
private final AgentRepo agentRepo;

    public AgentService(AgentRepo agentRepo) {
        this.agentRepo = agentRepo;
    }
    public Agent saveAgent(Agent agent){
           return agentRepo.save(agent);
    }

    public Optional<Agent> findByTown(String town) {
           return agentRepo.findByTown(town);
    }

    public List<Agent> findAll() {
        return agentRepo.findAll();
    }

    public boolean existsByTown(String town) {
        return agentRepo.existsByTown(town);
    }

}
