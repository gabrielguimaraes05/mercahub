package com.mercahub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerAddress {
  private String addressLine;
  private String zipCode;
  private LocationElement city;
  private LocationElement state;
  private LocationElement country;
  private Double latitude;
  private Double longitude;
  private Long id;
}
