package com.example.Aonji.Transport.Controller;

import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Entities.Dto.BillResponseDto;
import com.example.Aonji.Transport.Service.BillService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
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
    public List<Bill>findByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return billService.findByDate(date);
    }

    @GetMapping("/findByDate2/{date}")
    public List<BillResponseDto> findByDate2(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        return billService.findByDate(date)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private BillResponseDto convertToDTO(Bill bill) {
        BillResponseDto dto = new BillResponseDto();
        dto.setId(bill.getId());
        dto.setLr_no(bill.getLr_no());
        dto.setNo_of_parcels(bill.getNo_of_parcels());
        dto.setDate(bill.getDate());
        dto.setParcel_description(bill.getParcel_description());
        dto.setCost(bill.getCost());
        dto.setPaid(bill.isPaid());
        dto.setConsignor(bill.getConsignor());
        dto.setConsignee(bill.getConsignee());
        dto.setTo_townOrCity(bill.getTo_townOrCity());
        dto.setFrom_TownOrCity(bill.getFrom_TownOrCity());
        dto.setFrom_mobile(bill.getFrom_mobile());
        dto.setTo_mobile(bill.getTo_mobile());
        dto.setAgentMobile(bill.getAgent().getMobile());
        return dto;
    }


}
