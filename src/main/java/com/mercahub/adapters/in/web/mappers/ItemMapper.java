package com.mercahub.adapters.in.web.mappers;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercahub.domain.Item;
import com.mercahub.dto.ItemDto;
import com.mercahub.dto.ItemSummaryDto;

@Component
public class ItemMapper {

    private final ObjectMapper objectMapper;

    public ItemMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ItemDto toDto(Item item) {
        return objectMapper.convertValue(item, ItemDto.class);
    }

    public ItemSummaryDto toSummaryDto(Item item) {
         return objectMapper.convertValue(item, ItemSummaryDto.class);
    }
}
