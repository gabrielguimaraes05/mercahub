package com.mercahub.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Variation {
  private Long id;
  private Double price;
  private List<AttributeCombination> attributeCombinations;
  private Integer availableQuantity;
  private Integer soldQuantity;
  private List<String> pictureIds;
  private String userProductId;
}
