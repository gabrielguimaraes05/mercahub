package com.mercahub.adapters.in.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mercahub.adapters.in.web.errors.InternalServerException;
import com.mercahub.adapters.in.web.errors.ItemNotFoundException;
import com.mercahub.adapters.in.web.mappers.ItemMapper;
import com.mercahub.api.ItemApi;
import com.mercahub.application.GetItemUseCase;
import com.mercahub.application.ListItemsUseCase;
import com.mercahub.domain.Item;
import com.mercahub.dto.ItemDto;
import com.mercahub.dto.ItemSummaryDto;
import com.mercahub.ports.ItemRepository;

@RestController
public class ItemController implements ItemApi {

    private final GetItemUseCase getItemUseCase;
    private final ListItemsUseCase listItemsUseCase;
    private final ItemMapper itemMapper;

    public ItemController(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.getItemUseCase = new GetItemUseCase(itemRepository);
        this.listItemsUseCase = new ListItemsUseCase(itemRepository);
        this.itemMapper = itemMapper;
    }

    @Override
    @GetMapping("/item/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable String id) {
        try {
            Item item = getItemUseCase.execute(id);

            if (item == null) {
                throw new ItemNotFoundException(id);
            }

            return ResponseEntity.ok(itemMapper.toDto(item));
        } catch (Exception e) {
            throw new InternalServerException(id);
        }
    }

    @GetMapping("/items")
    public ResponseEntity<List<ItemSummaryDto>> listItems(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<Item> items = listItemsUseCase.execute(page, size);
            List<ItemSummaryDto> response = items.stream()
                    .map(itemMapper::toSummaryDto)
                    .toList();
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            throw new InternalServerException("page=" + page + ",size=" + size);
        }
    }
}
