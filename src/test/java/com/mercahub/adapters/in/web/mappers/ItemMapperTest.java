package com.mercahub.adapters.in.web.mappers;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercahub.domain.Attribute;
import com.mercahub.domain.Item;
import com.mercahub.domain.Picture;
import com.mercahub.domain.SaleTerm;
import com.mercahub.domain.SaleTermValue;
import com.mercahub.domain.SellerAddress;
import com.mercahub.domain.Variation;
import java.time.OffsetDateTime;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ItemMapperTest {

  private ItemMapper mapper;

  @BeforeEach
  void setUp() {
    mapper = new ItemMapper(new ObjectMapper());
  }

  @Test
  void deveMapearItemParaItemSummaryDto() {
    Item item = criarItemCompleto();

    var dto = mapper.toSummaryDto(item);

    assertThat(dto.getId()).isEqualTo(item.getId());
    assertThat(dto.getTitle()).isEqualTo(item.getTitle());
    assertThat(dto.getPrice()).isEqualTo(item.getPrice());
    assertThat(dto.getStatus()).isEqualTo(item.getStatus());
    assertThat(dto.getChannels()).containsExactlyElementsOf(item.getChannels());
  }

  private Item criarItemCompleto() {
    OffsetDateTime now = OffsetDateTime.now();
    return new Item(
        "MLB1",
        "MLB",
        "Tênis",
        "Family",
        123L,
        "CAT1",
        199.9,
        199.9,
        null,
        "BRL",
        1,
        1,
        0,
        Collections.singletonList(
            new SaleTerm(
                "ST",
                "Term",
                "VID",
                "Name",
                Collections.singletonList(new SaleTermValue("1", "Value")),
                "type")),
        "buy_it_now",
        "gold",
        now,
        now,
        now,
        now,
        "new",
        "permalink",
        "thumbId",
        "thumb",
        Collections.singletonList(new Picture("P1", "url", "secure", "100x100", "200x200")),
        null,
        true,
        new SellerAddress("Rua", "00000-000", null, null, null, 0.0, 0.0, 1L),
        Collections.singletonList(
            new Attribute(
                "A1",
                "Attr",
                "VID",
                "Value",
                Collections.singletonList(new SaleTermValue("1", "Value")),
                "string")),
        Collections.singletonList(
            new Variation(
                1L, 199.9, Collections.emptyList(), 1, 0, Collections.singletonList("P1"), null)),
        "active",
        "warranty",
        "catalog",
        "domain",
        now,
        now,
        Collections.singletonList("online"));
  }
}
