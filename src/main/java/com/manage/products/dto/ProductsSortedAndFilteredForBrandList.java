package com.manage.products.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductsSortedAndFilteredForBrandList {
    private String brandName;
    private List<ProductDto> productDto;
}
