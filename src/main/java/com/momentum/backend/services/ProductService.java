package com.momentum.backend.services;

import com.momentum.backend.models.Investor;
import com.momentum.backend.models.Product;
import com.momentum.backend.repository.InvestorRepository;
import com.momentum.backend.repository.ProductRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @SneakyThrows
    public List<Product> getAllProducts() throws Exception {
        try {
//            List<Product> products = ProductRepository.getAllProducts();
            List<Product> products = productRepository.findAll();

            if (products.isEmpty()){
                return null;
            }
            return products;
        } catch (Exception e) {
            throw new Exception("Error occurred while getting investors details " + e);
        }
    };

}