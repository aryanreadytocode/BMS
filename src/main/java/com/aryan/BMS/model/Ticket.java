package com.aryan.BMS.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    private double totalAmount;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<ShowSeat> showSeats;
    @ManyToOne
    private User bookedBy;
    @OneToOne
    private Payment payment;
    // add ticket status by requirement

}
