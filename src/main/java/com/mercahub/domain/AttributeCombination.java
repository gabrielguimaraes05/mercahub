package com.mercahub.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttributeCombination {
  private String id;
  private String name;
  private String valueId;
  private String valueName;
  private List<SaleTermValue> values;
  private String valueType;
}
