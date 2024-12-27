package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Repository.AgentRepo;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
private final AgentRepo agentRepo;

    public AgentService(AgentRepo agentRepo) {
        this.agentRepo = agentRepo;
    }
    public Agent saveAgent(Agent agent){
        return agentRepo.save(agent);
    }

    public Agent findByCityOrTown(String cityOrTown) {
           return agentRepo.findByCityOrTown(cityOrTown);
    }
}
