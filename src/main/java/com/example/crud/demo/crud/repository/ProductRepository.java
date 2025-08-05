package com.example.crud.demo.crud.repository;

import com.example.crud.demo.crud.entity.Product;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
    Product findByName(String name);
}
