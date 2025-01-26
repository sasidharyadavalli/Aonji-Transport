package com.example.Aonji.Transport.Controller;

import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.Dto.BillResponseDto;
import com.example.Aonji.Transport.Service.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bill")
public class BillController {
private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveBill(@RequestBody Bill bill){
       return billService.saveBill(bill);
    }

    @GetMapping("/findByDate/{date}")
    public List<BillResponseDto> findByDate2(@PathVariable  LocalDate date) {
        return billService.findByDate(date)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @GetMapping("/getCurrentList/{town}")
    public List<BillResponseDto> getUnreachedBillsByTown(@PathVariable String town) {
        return billService.getUnreachedBillsByTown(town)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
     @PutMapping("toggleReachedById")
     public ResponseEntity<Map<String,Object>>toggleReachedById(@RequestBody List<Long>ids){
        return billService.toggleReachedById(ids);
     }

     @GetMapping("findByLrNo/{LrNo}")
     public ResponseEntity<?> getBillByLrNo(@PathVariable Long LrNo){
          try {
          Optional<Bill>bill= billService.findByLrNo(LrNo);
           if (bill.isPresent()){
               return ResponseEntity.ok(convertToDTO(bill.get()));
           }else {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found bill with given lr_no");
           }
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("error occurred while retrieving the bill ");
        }
     }

      @GetMapping("getByDateAndTown/{date}/{to}")
      public List<BillResponseDto> getByDateAndTown(@PathVariable LocalDate date,@PathVariable String to){

           return billService.findByDateAndToTown(date,to)
                   .stream()
                   .map(this::convertToDTO)
                   .collect(Collectors.toList());

      }

      @GetMapping("getByConsignorAndDate/{consignor}/{date}")
      public List<BillResponseDto>getByConsignorAndDate(@PathVariable String consignor,@PathVariable LocalDate date){
        return billService.findByConsignorAndDate(consignor,date)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

      }
      @GetMapping("/getByConsignor/{consignor}")
      public List<BillResponseDto>getByConsignor(@PathVariable String consignor){
         return billService.findByConsignor(consignor)
                 .stream()
                 .map(this::convertToDTO)
                 .collect(Collectors.toList());
      }

      @GetMapping("/getByConsigneeAndDate/{consignee}/{date}")
      public List<BillResponseDto>getByConsigneeAndDate(@PathVariable String consignee,@PathVariable LocalDate date){
        return billService.findByConsigneeAndDate(consignee,date)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
      }
      @GetMapping("/getByConsignee")
      public List<BillResponseDto>getByConsignee(@PathVariable String consignee){
        return billService.findByConsignee(consignee)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
      }

      @GetMapping("/getByTown/{toTown}")
      public List<BillResponseDto>findByTown(@PathVariable String toTown){
        return billService.findByToTown(toTown)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
      }


    private BillResponseDto convertToDTO(Bill bill) {
        BillResponseDto dto = new BillResponseDto();
        dto.setId(bill.getId());
        dto.setLrNo(bill.getLrNo());
        dto.setNo_of_parcels(bill.getNo_of_parcels());
        dto.setDate(bill.getDate());
        dto.setParcel_description(bill.getParcel_description());
        dto.setCost(bill.getCost());
        dto.setPaid(bill.isPaid());
        dto.setConsignor(bill.getConsignor());
        dto.setConsignee(bill.getConsignee());
        dto.setTo(bill.getToTown()+"-"+bill.getAgent().getName()+"-"+bill.getAgent().getMobile());
        dto.setFrom(bill.getFrom_TownOrCity()+"-Aonji_Transport-8106226616");
        dto.setFrom_mobile(bill.getFrom_mobile());
        dto.setTo_mobile(bill.getTo_mobile());
        dto.setAgentMobile(bill.getAgent().getMobile());
        if(bill.getDetails()!=null){
            dto.setDetails(bill.getDetails());
        }
        dto.setReached(bill.getReached());
        return dto;
    }


}
