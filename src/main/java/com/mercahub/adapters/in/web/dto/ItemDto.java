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
public class ItemDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("site_id")
    private String siteId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("family_name")
    private String familyName;

    @JsonProperty("seller_id")
    private Long sellerId;

    @JsonProperty("category_id")
    private String categoryId;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("base_price")
    private Double basePrice;

    @JsonProperty("original_price")
    private Double originalPrice;

    @JsonProperty("currency_id")
    private String currencyId;

    @JsonProperty("initial_quantity")
    private Integer initialQuantity;

    @JsonProperty("available_quantity")
    private Integer availableQuantity;

    @JsonProperty("sold_quantity")
    private Integer soldQuantity;

    @Valid
    @JsonProperty("sale_terms")
    private List<SaleTermDto> saleTerms;

    @JsonProperty("buying_mode")
    private String buyingMode;

    @JsonProperty("listing_type_id")
    private String listingTypeId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("start_time")
    private OffsetDateTime startTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("stop_time")
    private OffsetDateTime stopTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("end_time")
    private OffsetDateTime endTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonProperty("expiration_time")
    private OffsetDateTime expirationTime;

    @JsonProperty("condition")
    private String condition;

    @JsonProperty("permalink")
    private String permalink;

    @JsonProperty("thumbnail_id")
    private String thumbnailId;

    @JsonProperty("thumbnail")
    private String thumbnail;

    @Valid
    @JsonProperty("pictures")
    private List<PictureDto> pictures;

    @JsonProperty("video_id")
    private String videoId;

    @JsonProperty("accepts_mercadopago")
    private Boolean acceptsMercadopago;

    @JsonProperty("seller_address")
    private LocationElementDto sellerAddress;

    @Valid
    @JsonProperty("attributes")
    private List<AttributeDto> attributes;

    @Valid
    @JsonProperty("variations")
    private List<VariationDto> variations;
}
