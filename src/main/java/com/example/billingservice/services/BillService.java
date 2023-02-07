package com.example.billingservice.services;

import com.example.billingservice.dto.BillRequestDTO;
import com.example.billingservice.dto.BillResponseDTO;

import java.util.List;

public interface BillService {
    BillResponseDTO save(BillRequestDTO billRequestDTO);
    BillResponseDTO getBill(Long id);
    List<BillResponseDTO> billsByCustomer(Long customerID);
}
