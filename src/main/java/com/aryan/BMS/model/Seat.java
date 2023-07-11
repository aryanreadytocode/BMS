package com.aryan.BMS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    private String seatNumber;
    private int rowNo;
    private int columnNo;

    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    private Auditorium auditorium;
}

/*Seat -> SeatType -> M:1
Seat : Auditorium -> M:1
* */
