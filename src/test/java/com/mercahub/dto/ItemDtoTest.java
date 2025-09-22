package com.mercahub.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.mercahub.adapters.in.web.dto.ItemDto;

import org.junit.jupiter.api.Test;

class ItemDtoTest {

  private final ObjectMapper mapper =
      new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

  @Test
  void deveManterValoresNosGettersEEquals() {

    ItemDto dto = new ItemDto().setId("MLB1").setSiteId("MLB").setTitle("Tênis").setPrice(199.9);

    ItemDto copia = new ItemDto().setId("MLB1").setSiteId("MLB").setTitle("Tênis").setPrice(199.9);

    assertThat(dto.getId()).isEqualTo("MLB1");
    assertThat(dto.getTitle()).isEqualTo("Tênis");
    assertThat(dto.getPrice()).isEqualTo(199.9);
    assertThat(dto).isEqualTo(copia).hasSameHashCodeAs(copia);
  }

  @Test
  void deveSerializarEmSnakeCase() throws Exception {
    ItemDto dto = new ItemDto().setSiteId("MLB1").setTitle("MLB");

    String json = mapper.writeValueAsString(dto);

    assertThat(json).contains("\"site_id\":").contains("\"category_id\":");

    ItemDto desserializado = mapper.readValue(json, ItemDto.class);
    assertThat(desserializado.getSiteId()).isEqualTo("MLB1");
  }
}
