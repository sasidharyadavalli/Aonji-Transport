package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.FromCustomer;
import com.example.Aonji.Transport.Entities.ToCustomer;
import com.example.Aonji.Transport.Repository.BillRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    private final BillRepo billRepo;
    private final AgentService agentService;
    private final ToCustomerService toCustomerService;
    private final FromCustomerService fromCustomerService;

    public BillService(BillRepo billRepo, AgentService agentService, ToCustomerService toCustomerService, FromCustomerService fromCustomerService) {
        this.billRepo = billRepo;
        this.agentService = agentService;
        this.toCustomerService = toCustomerService;
        this.fromCustomerService = fromCustomerService;
    }

    public Bill saveBill(Bill bill){
        Agent agent=bill.getAgent();
       Agent agent1= agentService.saveAgent(agent);
       if (agent1==null){
           throw new RuntimeException("agent not saved");
       }

        ToCustomer toCustomer=bill.getToCustomer();
       toCustomerService.saveToCustomer(toCustomer);

        FromCustomer fromCustomer=bill.getFromCustomer();
        fromCustomerService.saveFromCustomer(fromCustomer);

        return billRepo.save(bill);
    }

}
