package com.mercahub.adapters.out.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercahub.domain.Item;
import com.mercahub.ports.ItemRepository;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository
public class JsonItemRepository implements ItemRepository {

  private final List<Item> items;
  private final Map<String, Item> itemsById;

  public JsonItemRepository(ObjectMapper mapper) {
    this.items = loadItems(mapper);
    this.itemsById = indexItems(items);
  }

  @Override
  public Item findById(String id) {
    return itemsById.get(id);
  }

  @Override
  public List<Item> findAll(int page, int size) {
    if (page < 0 || size < 1) {
      throw new IllegalArgumentException("Page must be >= 0 and size must be > 0");
    }

    int fromIndex = Math.min(page * size, items.size());
    int toIndex = Math.min(fromIndex + size, items.size());
    if (fromIndex >= toIndex) {
      return Collections.emptyList();
    }

    return List.copyOf(items.subList(fromIndex, toIndex));
  }

  private List<Item> loadItems(ObjectMapper mapper) {
    try (InputStream inputStream = getClass().getResourceAsStream("/items.json")) {
      if (inputStream == null) {
        throw new IllegalStateException("Resource /items.json not found");
      }

      List<Item> loadedItems = mapper.readValue(inputStream, new TypeReference<List<Item>>() {});
      return List.copyOf(loadedItems);
    } catch (IOException e) {
      throw new IllegalStateException("Failed to load items from items.json", e);
    }
  }

  private Map<String, Item> indexItems(List<Item> items) {
    Map<String, Item> index = new HashMap<>(items.size());
    for (Item item : items) {
      if (item.getId() != null) {
        index.put(item.getId(), item);
      }
    }
    return Collections.unmodifiableMap(index);
  }
}
