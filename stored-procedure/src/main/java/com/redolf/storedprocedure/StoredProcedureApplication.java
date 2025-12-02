package com.redolf.storedprocedure;

import com.redolf.storedprocedure.entity.Product;
import com.redolf.storedprocedure.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class StoredProcedureApplication {

    @Autowired
    private ProductRepository productRepository;

//    @PostConstruct
    public void saveProducts(){
        List<Product> products = List.of(
                Product.builder()
                        .sku(UUID.randomUUID().toString())
                        .productName("Hp Omen 15")
                        .productDescription("Gaming Laptop")
                        .unitPrice(7000)
                        .build(),
                Product.builder()
                        .sku(UUID.randomUUID().toString())
                        .productName("Alienware 20")
                        .productDescription("Gaming Laptop")
                        .unitPrice(9000)
                        .build(),
                Product.builder()
                        .sku(UUID.randomUUID().toString())
                        .productName("Republic of Gamers")
                        .productDescription("Gaming Laptop")
                        .unitPrice(10000)
                        .build()
        );
        productRepository.saveAll(products);
    }

    public static void main(String[] args) {
        SpringApplication.run(StoredProcedureApplication.class, args);
    }

}
