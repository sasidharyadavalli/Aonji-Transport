package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.FromCustomer;
import com.example.Aonji.Transport.Entities.Numbers.FromMobile;
import com.example.Aonji.Transport.Entities.Numbers.ToMobile;
import com.example.Aonji.Transport.Entities.ToCustomer;
import com.example.Aonji.Transport.Repository.BillRepo;
import com.example.Aonji.Transport.Repository.FromMobileRepo;
import com.example.Aonji.Transport.Repository.ToMobileRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillService {
    private final BillRepo billRepo;
    private final AgentService agentService;
    private final ToCustomerService toCustomerService;
    private final FromCustomerService fromCustomerService;
     private final ToMobileRepo toMobileRepo;
     private final FromMobileRepo fromMobileRepo;
    public BillService(BillRepo billRepo, AgentService agentService, ToCustomerService toCustomerService, FromCustomerService fromCustomerService, ToMobileRepo toMobileRepo, FromMobileRepo fromMobileRepo) {
        this.billRepo = billRepo;
        this.agentService = agentService;
        this.toCustomerService = toCustomerService;
        this.fromCustomerService = fromCustomerService;
        this.toMobileRepo = toMobileRepo;
        this.fromMobileRepo = fromMobileRepo;
    }

    public Bill saveBill(Bill bill){

        Long fromMobile=bill.getFromMobile().getMobile();
        String cityOrTown=bill.getTo_townOrCity();
        Agent agent=agentService.findByCityOrTown(cityOrTown);
        if(agent==null){
            agentService.saveAgent(bill.getAgent());
        }else {
            bill.setAgent(agent);
        }


        String name=bill.getToCustomer().getName();
      ToCustomer toCustomer=toCustomerService.findByName(name);
        Long toMobile=bill.getToMobile().getMobile();
        List<ToMobile>toMobiles=toCustomer.getToMobiles();
        ToMobile[]toMobiles1= toMobiles.toArray(new ToMobile[0]);
         String street=bill.getToCustomer().getStreet();
       boolean flag=false;
         for(int i=0;i<toMobiles1.length;i++){
           if(toMobile==toMobiles1[i].getMobile()){
               bill.setToCustomer(toCustomer);
               flag=true;
               break;
           }
       }
         if(!flag){
          if(street.equalsIgnoreCase(toCustomer.getStreet())){

              toCustomerService.saveToCustomer(bill.getToCustomer());
          }else {
              toMobileRepo.save(bill.getToMobile());
              bill.setToCustomer(toCustomer);
          }
         }




        String name2=bill.getFromCustomer().getName();
        FromCustomer fromCustomer=fromCustomerService.findByName(name);
        Long froMobile=bill.getFromMobile().getMobile();
        List<FromMobile>fromMobiles=fromCustomer.getFromMobiles();
        FromMobile[]fromMobiles1=fromMobiles.toArray(new FromMobile[0]);
        String street2=bill.getFromCustomer().getStreet();
        boolean flag2=false;
        for(int i=0;i<fromMobiles1.length;i++){
            if(froMobile==fromMobiles1[i].getMobile()){
                bill.setFromCustomer(fromCustomer);
                flag2=true;
                break;
            }
        }
        if(!flag2){
            if(street2.equalsIgnoreCase(fromCustomer.getStreet())){

                fromCustomerService.saveFromCustomer(bill.getFromCustomer());
            }else {
                fromMobileRepo.save(bill.getFromMobile());
                bill.setFromCustomer(fromCustomer);
            }
        }

        return billRepo.save(bill);
    }


}
