package com.jc.learn.springboot.microservices.itemsservice.service.impl;

import com.jc.learn.springboot.microservices.itemsservice.models.Item;
import com.jc.learn.springboot.microservices.itemsservice.models.Product;
import com.jc.learn.springboot.microservices.itemsservice.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private RestTemplate restTemplate;

    public ItemServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(restTemplate.getForObject("http://localhost:8001/list", Product[].class));
        return products.stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id",id.toString());
        Product product = restTemplate.getForObject("http://localhost:8001/view/{id}", Product.class, pathVariables);
        return new Item(product, quantity);
    }
}
