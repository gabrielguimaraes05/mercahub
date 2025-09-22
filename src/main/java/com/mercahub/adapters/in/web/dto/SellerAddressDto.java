package com.mercahub.adapters.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SellerAddressDto {

    @JsonProperty("address_line")
    private String addressLine;

    @JsonProperty("zip_code")
    private String zipCode;

    @Valid
    @JsonProperty("city")
    private LocationElementDto city;

    @Valid
    @JsonProperty("state")
    private LocationElementDto state;

    @Valid
    @JsonProperty("country")
    private LocationElementDto country;

    @JsonProperty("latitude")
    private Double latitude;

    @JsonProperty("longitude")
    private Double longitude;

    @JsonProperty("id")
    private Long id;
}
