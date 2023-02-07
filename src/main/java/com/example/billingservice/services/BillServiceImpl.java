package com.example.billingservice.services;

import com.example.billingservice.dto.BillRequestDTO;
import com.example.billingservice.dto.BillResponseDTO;
import com.example.billingservice.entities.Bill;
import com.example.billingservice.mappers.BillMapper;
import com.example.billingservice.openfiegn.CustomerRestClient;
import com.example.billingservice.repositories.BillRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;
    private final BillMapper billMapper;
    private final CustomerRestClient customerRestClient;

    public BillServiceImpl(BillRepository billRepository, BillMapper billMapper, CustomerRestClient customerRestClient) {
        this.billRepository = billRepository;
        this.billMapper = billMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public BillResponseDTO save(BillRequestDTO billRequestDTO) {
        Bill bill = billMapper.fromBillRequestDTO(billRequestDTO);
        bill.setDate(LocalDate.now());
        bill = billRepository.save(bill);
        return billMapper.fromBill(bill);
    }

    @Override
    public BillResponseDTO getBill(Long id) {
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomer(bill.getCustomerID()));
        return billMapper.fromBill(bill);
    }

    @Override
    public List<BillResponseDTO> billsByCustomer(Long customerID) {
        List<Bill> bills = billRepository.findByCustomerID(customerID);
        return bills
                .stream()
                .map(bill -> billMapper.fromBill(bill))
                .collect(Collectors.toList());
    }
}
