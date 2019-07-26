package com.jc.learn.springboot.microservices.productsservice.service.impl;

import com.jc.learn.springboot.microservices.productsservice.dao.ProductDao;
import com.jc.learn.springboot.microservices.productsservice.entity.Product;
import com.jc.learn.springboot.microservices.productsservice.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id).orElse(null);
    }
}
