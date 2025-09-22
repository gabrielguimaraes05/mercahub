package com.mercahub.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.mercahub.adapters.in.web.dto.ItemSummaryDto;

import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;

class ItemSummaryDtoTest {

  private final ObjectMapper mapper =
      new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

  @Test
  void deveManterValoresPrincipais() {
    OffsetDateTime now = OffsetDateTime.now();

    ItemSummaryDto dto =
        new ItemSummaryDto()
            .setId("MLB1")
            .setTitle("Tênis")
            .setPrice(199.9)
            .setDateCreated(now)
            .setLastUpdated(now);

    assertThat(dto.getId()).isEqualTo("MLB1");
    assertThat(dto.getTitle()).isEqualTo("Tênis");
    assertThat(dto.getPrice()).isEqualTo(199.9);
    assertThat(dto.getDateCreated()).isEqualTo(now);

    ItemSummaryDto outro =
        new ItemSummaryDto()
            .setId("MLB1")
            .setTitle("Tênis")
            .setPrice(199.9)
            .setDateCreated(now)
            .setLastUpdated(now);

    assertThat(dto).isEqualTo(outro).hasSameHashCodeAs(outro);
  }

  @Test
  void deveSerializarEDeSerializarEmSnakeCase() throws Exception {
    ItemSummaryDto dto =
        new ItemSummaryDto().setId("MLB1").setTitle("Tênis").setPrice(199.9);

    String json = mapper.writeValueAsString(dto);

    assertThat(json).contains("\"price\":");

    ItemSummaryDto copy = mapper.readValue(json, ItemSummaryDto.class);
    assertThat(copy.getPrice()).isEqualTo(199.9);
  }
}
