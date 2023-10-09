package com.momentum.backend.controllers;

import com.momentum.backend.controllers.models.APIResponse;
import com.momentum.backend.models.Investor;
import com.momentum.backend.models.Product;
import com.momentum.backend.repository.ProductRepository;
import com.momentum.backend.services.InvestorService;
import com.momentum.backend.services.ProductService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Path("/product/")
public class ProductController {
    @Autowired
    public ProductService productService;

    @Path("getAll")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
//    @Transactional(timeout = 30)
    public APIResponse getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
//            List<Product> products = productService.getAllProducts();

            if (products.isEmpty()) {
                return new APIResponse(true, "No product details returned", null, null);
            }
            return new APIResponse(true, "Product details returned successfully", products, null);
        } catch (Exception e) {
            return new APIResponse(false, "Error occurred while trying to retrieve product details ",
                    null, Collections.singletonList(e.getMessage()));
        }
    }

}