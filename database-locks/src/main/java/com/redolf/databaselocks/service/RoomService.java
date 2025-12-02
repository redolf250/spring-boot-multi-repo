package com.redolf.databaselocks.service;

import com.redolf.databaselocks.entity.Room;
import com.redolf.databaselocks.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room bookRoom(int roomId){
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        System.out.println(Thread.currentThread().getName()+" fetched room with  version "+room.getVersion());
        if (room.isBooked()) {
            throw new RuntimeException("Room is already booked.");
        }
        room.setBooked(true);
        return roomRepository.save(room);
    }
}
