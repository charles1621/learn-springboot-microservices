package com.jc.learn.springboot.microservices.itemsservice.service.impl;

import com.jc.learn.springboot.microservices.itemsservice.clients.ProductRestClient;
import com.jc.learn.springboot.microservices.itemsservice.models.Item;
import com.jc.learn.springboot.microservices.itemsservice.service.ItemService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class ItemServiceFeign implements ItemService {

    private ProductRestClient productRestClient;

    public ItemServiceFeign(ProductRestClient productRestClient) {
        this.productRestClient = productRestClient;
    }

    @Override
    public List<Item> findAll() {
        return productRestClient.list().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer quantity) {
        return new Item(productRestClient.detail(id), quantity);
    }
}
