package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.Agent;
import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.FromCustomer;
import com.example.Aonji.Transport.Entities.ToCustomer;
import com.example.Aonji.Transport.Repository.BillRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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


    public ResponseEntity<String> saveBill(Bill bill){

        String cityOrTown=bill.getTo_townOrCity();
        Agent agent=agentService.findByCityOrTown(cityOrTown);
        if(agent==null){
            if(bill.getAgent()!=null) {
                if(bill.getAgent().getName()!=null&&bill.getAgent().getMobile()!=null){
                    if(bill.getAgent().getCityOrTown()==null){
                        bill.getAgent().setCityOrTown(bill.getTo_townOrCity());
                    }
                    agentService.saveAgent(bill.getAgent());
                }else {
                    return new ResponseEntity<>("required atleast name and number of agent", HttpStatus.BAD_REQUEST);
                }
            }else {
                return new ResponseEntity<>("no agent found for entered city , please save agent details",HttpStatus.BAD_REQUEST);
            }
        }else {
            bill.setAgent(agent);
        }


        String name=bill.getConsignee();
        ToCustomer toCustomer=toCustomerService.findByName(name);
        if(toCustomer==null){
           if(bill.getToCustomer()!=null){
            if(bill.getTo_mobile()!=null) {
                bill.getToCustomer().setMobile(bill.getTo_mobile());
            }
            bill.getToCustomer().setCityOrTown(bill.getTo_townOrCity());
            bill.getToCustomer().setName(name);
            toCustomerService.saveToCustomer(bill.getToCustomer());
           }else {
               ToCustomer toCustomer1=new ToCustomer();
               toCustomer1.setName(name);
               toCustomer1.setCityOrTown(bill.getTo_townOrCity());
               if(bill.getTo_mobile()!=null){
                   toCustomer1.setMobile(bill.getTo_mobile());
               }
               bill.setToCustomer(toCustomer1);
               toCustomerService.saveToCustomer(toCustomer1);
           }
         }else {
            if(bill.getToCustomer()!=null){
            if(bill.getToCustomer().getStreet()!=null){
                toCustomer.setStreet(bill.getToCustomer().getStreet());
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



        String name2=bill.getConsignor();
        FromCustomer fromCustomer=fromCustomerService.findByName(name2);
        if(fromCustomer==null){
            if(bill.getFromCustomer()!=null) {
                if (bill.getFrom_mobile() != null) {
                    bill.getFromCustomer().setMobile(bill.getFrom_mobile());
                }
                bill.getFromCustomer().setCityOrTown(bill.getFrom_TownOrCity());
                bill.getFromCustomer().setName(name2);
                fromCustomerService.saveFromCustomer(bill.getFromCustomer());
            }else {
                FromCustomer fromCustomer1=new FromCustomer();
                fromCustomer1.setName(name2);
                fromCustomer1.setCityOrTown(bill.getFrom_TownOrCity());
                if(bill.getFrom_mobile()!=null){
                    fromCustomer1.setMobile(bill.getFrom_mobile());
                }
                bill.setFromCustomer(fromCustomer1);
                fromCustomerService.saveFromCustomer(fromCustomer1);
            }
            }else {
            if(bill.getFromCustomer()!=null) {
                if (bill.getFromCustomer().getStreet() != null) {
                    fromCustomer.setStreet(bill.getFromCustomer().getStreet());
                }
                if (bill.getFromCustomer().getLandmark() != null) {
                    fromCustomer.setLandmark(bill.getFromCustomer().getLandmark());
                }
                if (bill.getFromCustomer().getState() != null) {
                    fromCustomer.setState(bill.getFromCustomer().getState());
                }
                if (bill.getFromCustomer().getPinCode() != null) {
                    fromCustomer.setPinCode(bill.getFromCustomer().getPinCode());
                }
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
         try {
             Bill bill2= billRepo.save(bill);
             return new ResponseEntity<>("Bill saved successfully",HttpStatus.OK);
         }catch (Exception e){
             return new ResponseEntity<>("Error saving bill "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
         }
    }


    public List<Bill> findByDate(Date date){
        return billRepo.findByDate(date);
    }

}
