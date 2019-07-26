package com.jc.learn.springboot.microservices.productsservice.dao;

import com.jc.learn.springboot.microservices.productsservice.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Long> {
}
