package com.mercahub.adapters.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
public class ItemSummaryDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;
    
    @JsonProperty("price")
    private Double price;

    @JsonProperty("status")
    private String status;

    @JsonProperty("warranty")
    private String warranty;

    @JsonProperty("catalog_product_id")
    private String catalogProductId;

    @JsonProperty("domain_id")
    private String domainId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("date_created")
    private OffsetDateTime dateCreated;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("last_updated")
    private OffsetDateTime lastUpdated;

    @Valid
    @JsonProperty("channels")
    private List<String> channels;
}
