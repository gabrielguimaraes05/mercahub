package com.mercahub.application;

import java.util.List;

import com.mercahub.domain.Item;
import com.mercahub.ports.ItemRepository;

public class ListItemsUseCase {

    private final ItemRepository itemRepository;

    public ListItemsUseCase(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> execute(int page, int size) {
        return itemRepository.findAll(page, size);
    }
}
