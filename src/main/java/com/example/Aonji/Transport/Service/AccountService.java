package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.Accounts;
import com.example.Aonji.Transport.Repository.AccountRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
public final AccountRepo accountRepo;

    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public void saveAccount(Accounts account) {
     accountRepo.save(account);
    }
    public List<Accounts> findByMonthYearAndTo(int month,int year,String to){
        return accountRepo.findByMonthYearAndTo(month,year,to);
    }
}
