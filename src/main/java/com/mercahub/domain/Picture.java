package com.mercahub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Picture {
    private String id;
    private String url;
    private String secureUrl;
    private String size;
    private String maxSize;
}
