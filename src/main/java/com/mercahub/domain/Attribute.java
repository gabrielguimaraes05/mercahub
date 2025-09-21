package com.mercahub.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Attribute {
    private String id;
    private String name;
    private String valueId;
    private String valueName;
    private List<SaleTermValue> values;
    private String valueType;
}
