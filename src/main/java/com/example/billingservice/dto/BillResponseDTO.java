package com.example.billingservice.dto;

import com.example.billingservice.entities.Customer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class BillResponseDTO {
    private Long id ;
    private LocalDate date ;
    private BigDecimal amount ;
    private Customer customer;
}
