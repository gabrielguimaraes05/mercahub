package com.mercahub.adapters.in.web.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercahub.adapters.in.web.dto.ItemDto;
import com.mercahub.adapters.in.web.dto.ItemSummaryDto;
import com.mercahub.domain.Item;

import org.springframework.stereotype.Component;

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
    ItemSummaryDto summary = new ItemSummaryDto();
    summary.setId(item.getId());
    summary.setTitle(item.getTitle());
    summary.setPrice(item.getPrice());
    summary.setStatus(item.getStatus());
    summary.setWarranty(item.getWarranty());
    summary.setCatalogProductId(item.getCatalogProductId());
    summary.setDomainId(item.getDomainId());
    summary.setDateCreated(item.getDateCreated());
    summary.setLastUpdated(item.getLastUpdated());
    summary.setChannels(item.getChannels());
    return summary;
  }
}
