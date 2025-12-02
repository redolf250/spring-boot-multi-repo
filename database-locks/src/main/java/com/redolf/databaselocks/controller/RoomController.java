package com.redolf.databaselocks.controller;

import com.redolf.databaselocks.service.RoomService;
import com.redolf.databaselocks.service.RoomServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomServiceTest roomService;

    @GetMapping("/book/{roomId}")
    public String bookRoom(@PathVariable int roomId){
        roomService.bookRoom(roomId);
        return  "Room booked successfully";
    }
}
