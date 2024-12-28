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
            if(bill.getTo_mobile()!=null) {
                bill.getToCustomer().setMobile(bill.getTo_mobile());
            }
            toCustomerService.saveToCustomer(bill.getToCustomer());
         }else {
           if(toCustomer.getMobile()!=null&&bill.getTo_mobile()!=null){
               if(bill.getTo_mobile()==toCustomer.getMobile()){
                   bill.setToCustomer(toCustomer);
               }else {
                   if(toCustomer.getMobile2()!=null){
                      if(toCustomer.getMobile2()== bill.getTo_mobile()){
                          bill.setToCustomer(toCustomer);
                      }else {
                          toCustomer.setMobile2(bill.getTo_mobile());
                      }
                   }else {
                       toCustomer.setMobile2(bill.getTo_mobile());
                         bill.setToCustomer(toCustomer);
                   }
               }
           }else {
               toCustomer.setMobile(bill.getTo_mobile());
               bill.setToCustomer(toCustomer);
           }
         }

        String name2=bill.getFromCustomer().getName();
        FromCustomer fromCustomer=fromCustomerService.findByName(name2);
        if(fromCustomer==null){
            if(bill.getFrom_mobile()!=null) {
                bill.getFromCustomer().setMobile(bill.getFrom_mobile());
            }
            fromCustomerService.saveFromCustomer(bill.getFromCustomer());
        }else {
            if(fromCustomer.getMobile()!=null&&bill.getFrom_mobile()!=null){
                if(bill.getFrom_mobile()==fromCustomer.getMobile()){
                    bill.setFromCustomer(fromCustomer);
                }else {
                    if(fromCustomer.getMobile2()!=null){
                        if(fromCustomer.getMobile2()== bill.getFrom_mobile()){
                            bill.setFromCustomer(fromCustomer);
                        }else {
                            fromCustomer.setMobile2(bill.getFrom_mobile());
                        }
                    }else {
                        fromCustomer.setMobile2(bill.getFrom_mobile());
                        bill.setFromCustomer(fromCustomer);
                    }
                }
            }else {
                fromCustomer.setMobile(bill.getFrom_mobile());
                bill.setFromCustomer(fromCustomer);
            }
        }

        return billRepo.save(bill);
    }


}
