package com.redolf.databaselocks;

import com.redolf.databaselocks.entity.BusSeat;
import com.redolf.databaselocks.entity.Room;
import com.redolf.databaselocks.repository.BusSeatRepository;
import com.redolf.databaselocks.repository.RoomRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

@SpringBootApplication
public class DatabaseLocksApplication {

    @Autowired
    private BusSeatRepository repository;

    @Autowired
    private RoomRepository roomRepository;

//    @PostConstruct
    public  void sampleData(){
        var seat1 = new BusSeat();
        seat1.setBooked(false);
        var seat2 = new BusSeat();
        seat2.setBooked(false);
        var seat3= new BusSeat();
        seat3.setBooked(false);
        var seat4 = new BusSeat();
        seat4.setBooked(false);
        var seat5= new BusSeat();
        seat5.setBooked(false);
        repository.saveAll(List.of(seat1,seat2,seat3,seat4,seat5));
    }

//    @PostConstruct
    public  void sampleDataForRooms(){
        var room1 = new Room();
        room1.setBooked(false);
        room1.setRentAmount(7000);
        room1.setHostelName("NataRaj");

        var room2 = new Room();
        room2.setBooked(false);
        room2.setRentAmount(10000);
        room2.setHostelName("Divine");

        var room3= new Room();
        room3.setBooked(false);
        room3.setHostelName("Highland");
        room3.setRentAmount(6000);

        roomRepository.saveAll(List.of(room1,room2,room3));
    }

    public static void main(String[] args) {
        SpringApplication.run(DatabaseLocksApplication.class, args);
    }

}
