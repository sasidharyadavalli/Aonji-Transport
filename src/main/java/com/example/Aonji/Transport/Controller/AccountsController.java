package com.example.Aonji.Transport.Controller;

import com.example.Aonji.Transport.Entities.Accounts;
import com.example.Aonji.Transport.Service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountsController {

    private final AccountService accountService;

    public AccountsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/tripData/{month}/{year}/{to}")
    public List<Accounts>findByMonthYearAndTo(@PathVariable int month, @PathVariable int year, @PathVariable String to){
        return accountService.findByMonthYearAndTo(month,year,to);
    }
}
