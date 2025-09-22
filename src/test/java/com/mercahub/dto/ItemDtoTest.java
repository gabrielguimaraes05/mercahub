package com.mercahub.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;

class ItemDtoTest {

  private final ObjectMapper mapper =
      new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

  @Test
  void deveManterValoresNosGettersEEquals() {

    ItemDto dto = new ItemDto().id("MLB1").siteId("MLB").title("Tênis").price(199.9);

    ItemDto copia = new ItemDto().id("MLB1").siteId("MLB").title("Tênis").price(199.9);

    assertThat(dto.getId()).isEqualTo("MLB1");
    assertThat(dto.getTitle()).isEqualTo("Tênis");
    assertThat(dto.getPrice()).isEqualTo(199.9);
    assertThat(dto).isEqualTo(copia).hasSameHashCodeAs(copia);
  }

  @Test
  void deveSerializarEmSnakeCase() throws Exception {
    ItemDto dto = new ItemDto().id("MLB1").siteId("MLB").categoryId("CAT-1");

    String json = mapper.writeValueAsString(dto);

    assertThat(json).contains("\"site_id\":").contains("\"category_id\":");

    ItemDto desserializado = mapper.readValue(json, ItemDto.class);
    assertThat(desserializado.getSiteId()).isEqualTo("MLB");
  }
}
