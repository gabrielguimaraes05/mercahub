package com.mercahub.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Test;

public class SellerAddressDtoTest {

  private final ObjectMapper mapper =
      new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

  @Test
  void deveManterValoresNosGettersEEquals() {

    SellerAddress dto =
        new SellerAddress()
            .addressLine("Rua Teste, 415")
            .zipCode("13000000")
            .city(new LocationElement())
            .state(new LocationElement())
            .country(new LocationElement())
            .latitude(Double.MIN_NORMAL)
            .longitude(Double.MIN_NORMAL)
            .id(Long.MIN_VALUE);

    SellerAddress copia =
        new SellerAddress()
            .addressLine("Rua Teste, 415")
            .zipCode("13000000")
            .city(new LocationElement())
            .state(new LocationElement())
            .country(new LocationElement())
            .latitude(Double.MIN_NORMAL)
            .longitude(Double.MIN_NORMAL)
            .id(Long.MIN_VALUE);

    assertThat(dto.getId()).isEqualTo(Long.MIN_VALUE);
    assertThat(dto.getAddressLine()).isEqualTo("Rua Teste, 415");
    assertThat(dto.getZipCode()).isEqualTo("13000000");
    assertThat(dto).isEqualTo(copia).hasSameHashCodeAs(copia);
  }

  @Test
  void deveSerializarEmSnakeCase() throws Exception {
    SellerAddress dto =
        new SellerAddress()
            .addressLine("Rua Teste, 415")
            .zipCode("13000000")
            .city(new LocationElement())
            .state(new LocationElement())
            .country(new LocationElement())
            .latitude(Double.MIN_NORMAL)
            .longitude(Double.MIN_NORMAL)
            .id(Long.MIN_VALUE);

    String json = mapper.writeValueAsString(dto);

    assertThat(json)
        .contains("\"address_line\":")
        .contains("\"zip_code\":")
        .contains("\"city\":")
        .contains("\"state\":")
        .contains("\"country\":")
        .contains("\"latitude\":")
        .contains("\"longitude\":");

    SellerAddress desserializado = mapper.readValue(json, SellerAddress.class);
    assertThat(desserializado.getId()).isEqualTo(Long.MIN_VALUE);
  }
}
