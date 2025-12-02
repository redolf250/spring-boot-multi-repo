package com.redolf.springneo4j;

import com.redolf.springneo4j.entity.Manufacturer;
import com.redolf.springneo4j.entity.Supplier;
import com.redolf.springneo4j.repository.ManufacturerRepository;
import com.redolf.springneo4j.repository.SupplierRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringNeo4jApplication {

    @Autowired
    private SupplierRepository repository;

    @Autowired
    private ManufacturerRepository mRepository;

    @PostConstruct
    public void save(){

//        var record = mRepository.findByManufacturerName("iTech Systems")
//                .orElseThrow(()->  new RuntimeException("Record not found"));
//
//        record.setSupplier(repository.findByElementId("4:9198ab35-6a69-4bae-b690-22a3af8d323a:3").get());
//        mRepository.save(record);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setManufacturerName("Red. Tek");
        manufacturer.setManufacturerType("Full");
        manufacturer.setSupplier(repository.findByElementId("4:9198ab35-6a69-4bae-b690-22a3af8d323a:8").get());
        mRepository.save(manufacturer);

//        Supplier m = new Supplier();
//        m.setSupplierName("Tek Corporation");
//        m.setSupplierType("Full");
//        m.setManufacturer(manufacturer);
//        repository.save(m);


    }

    public static void main(String[] args) {
        SpringApplication.run(SpringNeo4jApplication.class, args);
    }

}
