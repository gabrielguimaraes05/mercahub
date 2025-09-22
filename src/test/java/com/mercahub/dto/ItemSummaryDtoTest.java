package com.mercahub.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
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
            .id("MLB1")
            .title("Tênis")
            .category("CALCADOS")
            .price(199.9)
            .dateCreated(now)
            .lastUpdated(now);

    assertThat(dto.getId()).isEqualTo("MLB1");
    assertThat(dto.getTitle()).isEqualTo("Tênis");
    assertThat(dto.getCategory()).isEqualTo("CALCADOS");
    assertThat(dto.getPrice()).isEqualTo(199.9);
    assertThat(dto.getDateCreated()).isEqualTo(now);

    ItemSummaryDto outro =
        new ItemSummaryDto()
            .id("MLB1")
            .title("Tênis")
            .category("CALCADOS")
            .price(199.9)
            .dateCreated(now)
            .lastUpdated(now);

    assertThat(dto).isEqualTo(outro).hasSameHashCodeAs(outro);
  }

  @Test
  void deveSerializarEDeSerializarEmSnakeCase() throws Exception {
    ItemSummaryDto dto =
        new ItemSummaryDto().id("MLB1").title("Tênis").category("CALCADOS").price(199.9);

    String json = mapper.writeValueAsString(dto);

    assertThat(json).contains("\"category\":").contains("\"price\":");

    ItemSummaryDto copy = mapper.readValue(json, ItemSummaryDto.class);
    assertThat(copy.getCategory()).isEqualTo("CALCADOS");
    assertThat(copy.getPrice()).isEqualTo(199.9);
  }
}
