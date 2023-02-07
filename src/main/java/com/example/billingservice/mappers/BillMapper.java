package com.example.billingservice.mappers;

import com.example.billingservice.dto.BillRequestDTO;
import com.example.billingservice.dto.BillResponseDTO;
import com.example.billingservice.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BillMapper {
    Bill fromBillRequestDTO(BillRequestDTO billRequestDTO);
    BillResponseDTO fromBill(Bill bill);
}
