package com.aryan.BMS.repository;

import com.aryan.BMS.model.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    @Lock(LockModeType.WRITE) // putting pessimistic lock on the below query
    List<ShowSeat> findByIdIn(List<Long> showSeatIds); // select * from showSeat where id in (...)
    ShowSeat save(ShowSeat seat); // save and update

}
