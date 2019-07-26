package com.jc.learn.springboot.microservices.productsservice.controller;

import com.jc.learn.springboot.microservices.productsservice.entity.Product;
import com.jc.learn.springboot.microservices.productsservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<Product> list() {
        return productService.findAll();
    }

    @GetMapping("/list/{id}")
    public Product detail(@PathVariable Long id) {
        return productService.findById(id);
    }
}
