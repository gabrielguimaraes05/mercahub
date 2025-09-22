package com.mercahub.ports;

import com.mercahub.domain.Item;
import java.util.List;

public interface ItemRepository {
  Item findById(String id);

  List<Item> findAll(int page, int size);
}
