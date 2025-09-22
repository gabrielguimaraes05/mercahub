package com.mercahub.adapters.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class VariationDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("price")
    private Double price;

    @Valid
    @JsonProperty("attribute_combinations")
    private List<AttributeCombinationDto> attributeCombinations;

    @JsonProperty("available_quantity")
    private Integer availableQuantity;

    @JsonProperty("sold_quantity")
    private Integer soldQuantity;

    @Valid
    @JsonProperty("picture_ids")
    private List<String> pictureIds;

    @JsonProperty("user_product_id")
    private String userProductId;
}
