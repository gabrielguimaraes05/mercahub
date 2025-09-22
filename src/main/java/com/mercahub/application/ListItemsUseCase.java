package com.mercahub.application;

import com.mercahub.domain.Item;
import com.mercahub.ports.ItemRepository;
import java.util.List;

public class ListItemsUseCase {

  private final ItemRepository itemRepository;

  public ListItemsUseCase(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public List<Item> execute(int page, int size) {
    return itemRepository.findAll(page, size);
  }
}
