package com.mercahub.adapters.in.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PictureDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("url")
    private String url;

    @JsonProperty("secure_url")
    private String secureUrl;

    @JsonProperty("size")
    private String size;

    @JsonProperty("max_size")
    private String maxSize;
}
