package com.example.Aonji.Transport.Service;

import com.example.Aonji.Transport.Entities.ToCustomer;
import com.example.Aonji.Transport.Repository.ToCustomerRepo;
import org.springframework.stereotype.Service;

@Service
public class ToCustomerService {
private final ToCustomerRepo toCustomerRepo;

    public ToCustomerService(ToCustomerRepo toCustomerRepo) {
        this.toCustomerRepo = toCustomerRepo;
    }
    public ToCustomer saveToCustomer(ToCustomer toCustomer){
        return toCustomerRepo.save(toCustomer);
    }

    public ToCustomer findByName(String name) {
       return toCustomerRepo.findByName(name);
    }
}
