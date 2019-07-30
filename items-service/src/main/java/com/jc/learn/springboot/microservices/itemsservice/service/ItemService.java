package com.jc.learn.springboot.microservices.itemsservice.service;

import com.jc.learn.springboot.microservices.itemsservice.models.Item;

import java.util.List;

public interface ItemService {

    List<Item> findAll();
    Item findById(Long id, Integer quantity);
}
