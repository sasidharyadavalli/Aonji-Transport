package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.*;
import com.example.Aonji.Transport.Repository.BillRepo;
import com.example.Aonji.Transport.Repository.DetailsRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.*;

@Service
public class BillService {
    private final BillRepo billRepo;
    private final AgentService agentService;
    private final DetailsRepo detailsRepo;
    private final AccountService accountService;
    private final ToCustomerService toCustomerService;
    private final FromCustomerService fromCustomerService;

    public BillService(BillRepo billRepo, AgentService agentService, DetailsRepo detailsRepo, AccountService accountService, ToCustomerService toCustomerService, FromCustomerService fromCustomerService) {
        this.billRepo = billRepo;
        this.agentService = agentService;
        this.detailsRepo = detailsRepo;
        this.accountService = accountService;
        this.toCustomerService = toCustomerService;
        this.fromCustomerService = fromCustomerService;
    }


    public ResponseEntity<String>saveBill(Bill bill){

        if (bill.getDetails() != null) {
            for (Details detail : bill.getDetails()) {
                detail.setBill(bill);
            }
        }
        bill.setReached(false);


        String town=bill.getToTown();
        Optional<Agent> agent=agentService.findByTown(town);
        if(agent.isPresent()){
            bill.setAgent(agent.get());
        }else {
            return ResponseEntity.badRequest().body("no agent found");
        }


        String name=bill.getConsignee();
        ToCustomer toCustomer=toCustomerService.findByName(name);
        if(toCustomer==null){
           if(bill.getToCustomer()!=null){
            if(bill.getTo_mobile()!=null) {
                bill.getToCustomer().setMobile(bill.getTo_mobile());
            }
            bill.getToCustomer().setCityOrTown(bill.getToTown());
            bill.getToCustomer().setName(name);
            toCustomerService.saveToCustomer(bill.getToCustomer());
           }else {
               ToCustomer toCustomer1=new ToCustomer();
               toCustomer1.setName(name);
               toCustomer1.setCityOrTown(bill.getToTown());
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
            if(bill.getToCustomer().getLandmark()!=null){
                toCustomer.setLandmark(bill.getToCustomer().getLandmark());
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


    public List<Bill> findByDate(LocalDate date){
        return billRepo.findByDate(date);
    }

    public List<Bill> getUnreachedBillsByTown(String town){
        return billRepo.findByToTownAndReachedFalse(town);
    }


    public ResponseEntity<Map<String,Object>> toggleReachedById(List<Long>ids) {
        StringBuilder responseMessage = new StringBuilder();
        double totalSum= 0d;
        double paidAmount=0d;
        double unPaidAmount=0d;
        for (Long id : ids) {
            int result = billRepo.toggleReachedById(id);
          if (result>0) {
              Double billCost = billRepo.findBillCostById(id);
              Double billCostPaid=billRepo.findBillCostByIdAndPaid(id);
               if (billCost!=null){
                   totalSum+=billCost;
               }else {
                   responseMessage.append("Bill with id ").append(id).append(" has no cost. ");
               }
              if (billCostPaid!=null) {
                  paidAmount += billCostPaid;
              }
          }else {
              responseMessage.append("failed to toggle bill id ").append(id).append(". ");
          }
        }
        unPaidAmount=totalSum-paidAmount;
        Long id1=ids.getFirst();
        String to=billRepo.findToTownById(id1);
        Optional<Agent> agent=agentService.findByTown(to);
        double agentShare = paidAmount * 0.10d;
        double agentShareUnpaidBills = unPaidAmount * 0.10d;
        double ourShare = unPaidAmount - agentShareUnpaidBills;
        Accounts account=new Accounts();
        account.setDate(LocalDate.now());
        account.setAgentShare(agentShare);
        account.setOurShare(ourShare);
        account.setPaidAmount(paidAmount);
        account.setUnPaidAmount(unPaidAmount);
        account.setTotalAmount(totalSum);
        account.setTo(to);
        account.setAgent(agent.get());
        account.setBillIds(ids);
       accountService.saveAccount(account);
        Map<String,Object>response=new HashMap<>();
        response.put("totalAmount",totalSum);
        response.put("paidAmount",paidAmount);
        response.put("unPaidAmount",unPaidAmount);
        response.put("message", !responseMessage.isEmpty() ?responseMessage.toString():"Toggled Successfully");
        return ResponseEntity.ok().body(response);
    }



    public Optional<Bill> findByLrNo(@PathVariable Long LrNo){
        return billRepo.findByLrNo(LrNo);
    }

    public List<Bill>findByDateAndToTown(LocalDate date,String toTownOrCity){
        return billRepo.findByDateAndToTown(date,toTownOrCity);
    }

    public List<Bill> findByConsignorAndDate(String consignor, LocalDate date) {
         return billRepo.findByConsignorAndDate(consignor,date);
    }

    public List<Bill> findByConsignor(String consignor) {
        return billRepo.findByConsignor(consignor);
    }

    public List<Bill> findByConsigneeAndDate(String consignee, LocalDate date) {
       return billRepo.findByConsigneeAndDate(consignee,date);
    }

    public List<Bill> findByConsignee(String consignee) {
          return billRepo.findByConsignee(consignee);
    }

    public List<Bill> findByToTown(String toTown) {
        return billRepo.findByToTown(toTown);
    }
}
