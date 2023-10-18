package com.momentum.backend.repository;

import com.momentum.backend.models.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
//    @Query(value = "CALL public.GetAllProducts()", nativeQuery = true)
//    List<Product> getAllProducts();
    @Override
    List<Product> findAll();
}