package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.FromCustomer;
import com.example.Aonji.Transport.Entities.ToCustomer;
import com.example.Aonji.Transport.Repository.BillRepo;
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
        String cityOrTown=bill.getTo_townOrCity();
        Agent agent=agentService.findByCityOrTown(cityOrTown);
        if(agent==null){
            agentService.saveAgent(bill.getAgent());
        }else {
            bill.setAgent(agent);
        }

        String name=bill.getToCustomer().getName();
        ToCustomer toCustomer=toCustomerService.findByName(name);
         if(toCustomer==null){
             toCustomerService.saveToCustomer(bill.getToCustomer());
         }else {
             bill.setToCustomer(toCustomer);
         }


        String name2=bill.getFromCustomer().getName();
        FromCustomer fromCustomer=fromCustomerService.findByName(name2);
       if(fromCustomer==null){
           fromCustomerService.saveFromCustomer(bill.getFromCustomer());
       }else {
          bill.setFromCustomer(fromCustomer);
       }


        return billRepo.save(bill);
    }


}
