package com.jc.learn.springboot.microservices.productsservice.service;

import com.jc.learn.springboot.microservices.productsservice.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long id);
}
