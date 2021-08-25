package com.mtr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtr.model.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Integer> {

}
