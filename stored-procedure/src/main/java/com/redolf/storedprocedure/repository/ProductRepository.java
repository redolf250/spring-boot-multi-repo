package com.redolf.storedprocedure.repository;

import com.redolf.storedprocedure.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Procedure
    List<Product> getAllProducts();

    @Procedure(value = "getProductById")
    Product findProductById(@Param("productId") int productId);

    @Procedure(value = "countAllProducts")
    Integer countAllProducts();
}