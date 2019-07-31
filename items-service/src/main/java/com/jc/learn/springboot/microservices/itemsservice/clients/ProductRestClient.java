package com.jc.learn.springboot.microservices.itemsservice.clients;

import com.jc.learn.springboot.microservices.itemsservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "localhost:8001")
public interface ProductRestClient {

    @GetMapping("/list")
    List<Product> list();

    @GetMapping("/view/{id}")
    Product detail(@PathVariable Long id);
}
