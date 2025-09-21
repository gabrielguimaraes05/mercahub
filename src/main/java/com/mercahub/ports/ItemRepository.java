package com.mercahub.ports;

import java.util.List;

import com.mercahub.domain.Item;

public interface ItemRepository {
    Item findById(String id);

    List<Item> findAll(int page, int size);
}
