package com.mercahub.adapters.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LocationElementDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
