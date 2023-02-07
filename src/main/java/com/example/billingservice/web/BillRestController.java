package com.example.billingservice.web;

import com.example.billingservice.dto.BillRequestDTO;
import com.example.billingservice.dto.BillResponseDTO;
import com.example.billingservice.services.BillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class BillRestController {
    private final BillService billService;

    public BillRestController(BillService billService) {
        this.billService = billService;
    }

    @GetMapping("/bills/{id}")
    public BillResponseDTO getBill(@PathVariable Long id){
        return billService.getBill(id);
    }

    @GetMapping("/bills/{customerId}")
    public List<BillResponseDTO> getBillsByCustomer(@PathVariable(name = "customerId") Long customerID){
        return billService.billsByCustomer(customerID);
    }

    @PostMapping("/bills")
    public BillResponseDTO save(BillRequestDTO billRequestDTO){
        return billService.save(billRequestDTO);
    }
}
