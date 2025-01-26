package com.example.Aonji.Transport.Controller;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Service.AgentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agent")
public class AgentController {

    private final AgentService agentService;

    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/getAll")
    public List<Agent>getAllAgent(){
        return agentService.findAll();
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Agent agent){
      if (agentService.existsByTown(agent.getTown())){
          return ResponseEntity.badRequest().body("agent already exist for given town");
      }
        try{
            agentService.saveAgent(agent);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("error occurred while saving agent");
        }
        return ResponseEntity.ok("agent saved successfully");
    }

    @GetMapping("/getByTown/{town}")
    public ResponseEntity<?> getByTown(@PathVariable String town){
        Optional<Agent>agent= agentService.findByTown(town);
       if (agent.isPresent()){
           return ResponseEntity.ok(agent.get());
       }else {
           return ResponseEntity.badRequest().body("no agent found for entered town");
       }
    }

    @PutMapping("/update/{town}")
    public ResponseEntity<?>update(@RequestBody Agent agent,@PathVariable String town){
        Optional<Agent>existingAgent=agentService.findByTown(town);
        if (existingAgent.isPresent()) {
            Agent agentToUpdate = existingAgent.get();
            if (agent.getName() != null) {
                agentToUpdate.setName(agent.getName());
            }
            if (agent.getMobile() != null) {
                agentToUpdate.setMobile(agent.getMobile());
            }
            if (agent.getLandmark() != null) {
                agentToUpdate.setLandmark(agent.getLandmark());
            }
            if (agent.getStreet() != null) {
                agentToUpdate.setStreet(agent.getStreet());
            }
            if (agent.getState() != null) {
                agentToUpdate.setState(agent.getState());
            }
            if (agent.getPinCode() != null) {
                agentToUpdate.setPinCode(agent.getPinCode());
            }
            if (agent.getTown() != null) {
                agentToUpdate.setTown(agent.getTown());
            }

            agentService.saveAgent(agentToUpdate);

            return ResponseEntity.ok("Agent updated successfully");
        } else {
            return ResponseEntity.status(404).body("No agent found for the entered town");
        }
    }
}
