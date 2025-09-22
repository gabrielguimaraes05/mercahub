package com.mercahub.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.mercahub.adapters.in.web.dto.LocationElementDto;
import com.mercahub.adapters.in.web.dto.SellerAddressDto;
import com.mercahub.domain.SellerAddress;

import org.junit.jupiter.api.Test;

public class SellerAddressDtoTest {

  private final ObjectMapper mapper =
      new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);

  @Test
  void deveManterValoresNosGettersEEquals() {

    SellerAddressDto dto = new SellerAddressDto()
            .setAddressLine("Rua Teste, 415")
            .setZipCode("13000000")
            .setCity(new LocationElementDto())
            .setState(new LocationElementDto())
            .setCountry(new LocationElementDto())
            .setLatitude(Double.MIN_NORMAL)
            .setLatitude(Double.MIN_NORMAL)
            .setId(Long.MIN_VALUE);

    SellerAddressDto copia = new SellerAddressDto()
            .setAddressLine("Rua Teste, 415")
            .setZipCode("13000000")
            .setCity(new LocationElementDto())
            .setState(new LocationElementDto())
            .setCountry(new LocationElementDto())
            .setLatitude(Double.MIN_NORMAL)
            .setLatitude(Double.MIN_NORMAL)
            .setId(Long.MIN_VALUE);

    assertThat(dto.getId()).isEqualTo(Long.MIN_VALUE);
    assertThat(dto.getAddressLine()).isEqualTo("Rua Teste, 415");
    assertThat(dto.getZipCode()).isEqualTo("13000000");
    assertThat(dto).isEqualTo(copia).hasSameHashCodeAs(copia);
  }

  @Test
  void deveSerializarEmSnakeCase() throws Exception {
    SellerAddressDto dto = new SellerAddressDto()
            .setAddressLine("Rua Teste, 415")
            .setZipCode("13000000")
            .setCity(new LocationElementDto())
            .setState(new LocationElementDto())
            .setCountry(new LocationElementDto())
            .setLatitude(Double.MIN_NORMAL)
            .setLatitude(Double.MIN_NORMAL)
            .setId(Long.MIN_VALUE);

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
