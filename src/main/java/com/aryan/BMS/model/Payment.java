package com.aryan.BMS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private Double amount;
    private Date timeStamp;
    private String transactionNo;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @OneToOne
    private Ticket ticket;

}
/*
* payment : payment_status : M: 1
* Successful -> p1, p2, p3
* Payment : Ticket -> 1 : 1*/
