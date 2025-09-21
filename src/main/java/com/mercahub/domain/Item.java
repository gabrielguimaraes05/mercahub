package com.mercahub.domain;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    private String id;
    private String siteId;
    private String title;
    private String familyName;
    private Long sellerId;
    private String categoryId;
    private Double price;
    private Double basePrice;
    private Double originalPrice;
    private String currencyId;
    private Integer initialQuantity;
    private Integer availableQuantity;
    private Integer soldQuantity;

    private List<SaleTerm> saleTerms;
    private String buyingMode;
    private String listingTypeId;

    private OffsetDateTime startTime;
    private OffsetDateTime stopTime;
    private OffsetDateTime endTime;
    private OffsetDateTime expirationTime;

    private String condition;
    private String permalink;
    private String thumbnailId;
    private String thumbnail;

    private List<Picture> pictures;
    private String videoId;

    private boolean acceptsMercadopago;

    private SellerAddress sellerAddress;

    private List<Attribute> attributes;
    private List<Variation> variations;

    private String status;
    private String warranty;
    private String catalogProductId;
    private String domainId;

    private OffsetDateTime dateCreated;
    private OffsetDateTime lastUpdated;

    private List<String> channels;
}