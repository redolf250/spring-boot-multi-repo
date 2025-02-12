package com.redolf.databaselocks.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @SneakyThrows
    public void bookRoom(int roomId){


        Thread thread1 = new Thread(()->{
            roomBooking(roomId);
        });
        Thread thread2 = new Thread(()->{
            roomBooking(roomId);
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    private void roomBooking(int roomId) {
            try {
                System.out.println(Thread.currentThread().getName()+" is attempting to book room: "+ roomId);
                var room =  roomService.bookRoom(roomId);
                System.out.println(Thread.currentThread().getName()+" successfully book room with version: "+room.getVersion());
            }catch (Exception e){
                System.out.println(Thread.currentThread().getName()+" failed to book room: "+ e.getMessage());
            }
    }

}
