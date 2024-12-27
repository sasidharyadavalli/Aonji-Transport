package com.example.Aonji.Transport.Controller;

import com.example.Aonji.Transport.Entities.Bill;
import com.example.Aonji.Transport.Service.BillService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bill")
public class BillController {
private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }
    @PostMapping("/save")
    public Bill saveBill(@RequestBody Bill bill){
       return billService.saveBill(bill);
    }


}
