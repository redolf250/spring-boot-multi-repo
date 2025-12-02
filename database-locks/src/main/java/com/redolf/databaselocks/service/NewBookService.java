package com.redolf.databaselocks.service;

import com.redolf.databaselocks.entity.BusSeat;
import com.redolf.databaselocks.repository.BusSeatRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewBookService {

    @Autowired
    private BusSeatRepository repository;

    @Transactional
    public void getBusSeat(BusSeat busSeat){
        System.out.println(Thread.currentThread().getName()+": is Attempting to fetch seat");
        BusSeat seat = repository
                .findBusSeatsById(busSeat.getId());
        System.out.println(Thread.currentThread().getName()+": acquired lock for seat Id "+ busSeat.getId());
        if (seat.isBooked())
            throw new IllegalStateException("Seat is already booked");
        seat.setBooked(true);
        seat.setPassengerName(busSeat.getPassengerName());
        repository.save(seat);
        System.out.println(Thread.currentThread().getName()+":booked seat with ID: "+ busSeat.getId());
    }
}
