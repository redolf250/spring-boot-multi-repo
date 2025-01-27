package com.redolf.databaselocks.controller;

import com.redolf.databaselocks.entity.BusSeat;
import com.redolf.databaselocks.service.BusSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat-booking")
public class SeatBookingController {

    @Autowired
    private BusSeatService seatService;

    @PostMapping("/book")
    public void bookSeat(@RequestBody BusSeat busSeat) throws InterruptedException {
        try {
            seatService.bookSeat(busSeat);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
