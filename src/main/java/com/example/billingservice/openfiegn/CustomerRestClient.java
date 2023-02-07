package com.example.billingservice.openfiegn;

import com.example.billingservice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    Customer getCustomer(@PathVariable(name = "id") Long id);

    @GetMapping(path = "/api/customers")
    List<Customer> allCustomers();

}
