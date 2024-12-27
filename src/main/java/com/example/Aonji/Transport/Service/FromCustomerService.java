package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.FromCustomer;
import com.example.Aonji.Transport.Repository.FromCustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class FromCustomerService {
private final FromCustomerRepo fromCustomerRepo;

    public FromCustomerService(FromCustomerRepo fromCustomerRepo) {
        this.fromCustomerRepo = fromCustomerRepo;
    }

    public FromCustomer saveFromCustomer(FromCustomer fromCustomer){
        return fromCustomerRepo.save(fromCustomer);
    }
}
