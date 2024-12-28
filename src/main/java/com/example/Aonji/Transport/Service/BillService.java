package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.FromCustomer;
import com.example.Aonji.Transport.Entities.ToCustomer;
import com.example.Aonji.Transport.Repository.BillRepo;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
            if(bill.getToCustomer().getStreet()!=null){
                toCustomer.setStreet(bill.getToCustomer().getStreet());
            }
            if(bill.getToCustomer().getCityOrTown()!=null){
                toCustomer.setCityOrTown(bill.getToCustomer().getCityOrTown());
            }
            if(bill.getToCustomer().getLandMark()!=null){
                toCustomer.setLandMark(bill.getToCustomer().getLandMark());
            }
            if(bill.getToCustomer().getState()!=null){
                toCustomer.setState(bill.getToCustomer().getState());
            }
            if(bill.getToCustomer().getPinCode()!=null){
                toCustomer.setPinCode(bill.getToCustomer().getPinCode());
            }
           if(toCustomer.getMobile()!=null&&bill.getTo_mobile()!=null){
               if(Objects.equals(bill.getTo_mobile(), toCustomer.getMobile())){
                   bill.setToCustomer(toCustomer);
               }else {
                  toCustomer.setMobile2(bill.getTo_mobile());
                  bill.setToCustomer(toCustomer);
               }
           }else {
               if(bill.getTo_mobile()!=null){
               toCustomer.setMobile(bill.getTo_mobile());
               }
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
            if(bill.getFromCustomer().getStreet()!=null){
                fromCustomer.setStreet(bill.getFromCustomer().getStreet());
            }
            if(bill.getFromCustomer().getCityOrTown()!=null){
                fromCustomer.setCityOrTown(bill.getFromCustomer().getCityOrTown());
            }
            if(bill.getFromCustomer().getLandmark()!=null){
                fromCustomer.setLandmark(bill.getFromCustomer().getLandmark());
            }
            if(bill.getFromCustomer().getState()!=null){
                fromCustomer.setState(bill.getFromCustomer().getState());
            }
            if(bill.getFromCustomer().getPinCode()!=null){
                fromCustomer.setPinCode(bill.getFromCustomer().getPinCode());
            }
            if(fromCustomer.getMobile()!=null&&bill.getFrom_mobile()!=null){
                if(Objects.equals(bill.getFrom_mobile(), fromCustomer.getMobile())){
                    bill.setFromCustomer(fromCustomer);
                }else {
                        fromCustomer.setMobile2(bill.getFrom_mobile());
                        bill.setFromCustomer(fromCustomer);
                }
            }else {
                if(bill.getFrom_mobile()!=null){
                    fromCustomer.setMobile(bill.getFrom_mobile());
                }
                bill.setFromCustomer(fromCustomer);
            }
        }
        return billRepo.save(bill);
    }


}
