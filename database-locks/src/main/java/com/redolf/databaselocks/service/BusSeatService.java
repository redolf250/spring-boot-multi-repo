package com.redolf.databaselocks.service;

import com.redolf.databaselocks.entity.BusSeat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusSeatService {

    @Autowired
    private NewBookService newBookService;


    public void bookSeat(BusSeat busSeat) throws InterruptedException {
        var thread = new Thread(() -> {
            try {
                busSeat.setPassengerName("Asamaning Redolf");
                newBookService.getBusSeat(busSeat);
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()+": "+e.getMessage());
                throw new RuntimeException(e);
            }

        });

        var thread1 = new Thread(() -> {
            try {
                busSeat.setPassengerName("Asamaning Kendrick Redolf");
                newBookService.getBusSeat(busSeat);
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName()+": "+e.getMessage());
                throw new RuntimeException(e);
            }

        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
