package com.manage.products.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductDto {
    private long id;
    private String name;
    private long price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String event;
}
