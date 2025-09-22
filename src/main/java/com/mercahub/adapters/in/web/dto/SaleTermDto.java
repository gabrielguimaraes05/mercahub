package com.mercahub.adapters.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class SaleTermDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("value_id")
    private String valueId;

    @JsonProperty("value_name")
    private String valueName;

    @Valid
    @JsonProperty("values")
    private List<SaleTermValueDto> values;

    @JsonProperty("value_type")
    private String valueType;
}
