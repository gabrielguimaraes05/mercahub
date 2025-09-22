package com.mercahub.application;

import com.mercahub.domain.Item;
import com.mercahub.ports.ItemRepository;

public class GetItemUseCase {
  private final ItemRepository itemRepository;

  public GetItemUseCase(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public Item execute(String id) {
    return itemRepository.findById(id);
  }
}
