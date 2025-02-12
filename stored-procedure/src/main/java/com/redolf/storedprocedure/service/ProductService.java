package com.redolf.storedprocedure.service;

import com.redolf.storedprocedure.entity.Product;
import com.redolf.storedprocedure.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.getAllProducts();
    }

    public Product getProductById(int productId) {
        return productRepository.findProductById(productId);
    }

    public Integer countAllProducts() {
        return productRepository.countAllProducts();
    }
}
