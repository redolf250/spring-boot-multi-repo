package com.redolf.databaselocks;

import com.redolf.databaselocks.entity.BusSeat;
import com.redolf.databaselocks.repository.BusSeatRepository;
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

    public static void main(String[] args) {
        SpringApplication.run(DatabaseLocksApplication.class, args);
    }

}
