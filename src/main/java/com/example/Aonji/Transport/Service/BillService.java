package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.*;
import com.example.Aonji.Transport.Entities.Dto.BillResponseDto;
import com.example.Aonji.Transport.Repository.BillRepo;
import com.example.Aonji.Transport.Repository.DetailsRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BillService {
    private final BillRepo billRepo;
    private final AgentService agentService;
    private final DetailsRepo detailsRepo;
    private final ToCustomerService toCustomerService;
    private final FromCustomerService fromCustomerService;

    public BillService(BillRepo billRepo, AgentService agentService, DetailsRepo detailsRepo, ToCustomerService toCustomerService, FromCustomerService fromCustomerService) {
        this.billRepo = billRepo;
        this.agentService = agentService;
        this.detailsRepo = detailsRepo;
        this.toCustomerService = toCustomerService;
        this.fromCustomerService = fromCustomerService;
    }


    public ResponseEntity<String>saveBill(Bill bill){

        if (bill.getDetails() != null) {
            for (Details detail : bill.getDetails()) {
                detail.setBill(bill);
            }
        }


        String cityOrTown=bill.getToTown();
        Agent agent=agentService.findByCityOrTown(cityOrTown);
        if(agent==null){
            if(bill.getAgent()!=null) {
                if(bill.getAgent().getName()!=null&&bill.getAgent().getMobile()!=null){
                    if(bill.getAgent().getCityOrTown()==null){
                        bill.getAgent().setCityOrTown(bill.getToTown());
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


    public List<Bill> findByDate(LocalDate date){
        return billRepo.findByDate(date);
    }

    public List<Bill> getUnreachedBillsByTown(String town){
        return billRepo.findByToTownAndReachedFalse(town);
    }


    public ResponseEntity<String> toggleReachedById(List<Long>ids){
         StringBuilder responseMessage=new StringBuilder();
         boolean hasErrors=false;
          try {
              for (Long id :ids) {
                  int result= billRepo.toggleReachedById(id);
                  if(result==0) {
                      hasErrors=true;
                     responseMessage.append("parcel with Id :").append(id).append(" not toggled successfully. ");
                  }
               }
          }catch (Exception e){

         return  ResponseEntity.internalServerError().body(" error occurred :not toggled successfully ,"+e.getMessage());
          }
          if (hasErrors){
              responseMessage.append(" Remaining parcels toggled successfully.");
              return ResponseEntity.status(207).body(responseMessage.toString());
          }else {
              responseMessage.append("parcels toggled successfully");
          }
      return ResponseEntity.ok(responseMessage.toString());
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

}
