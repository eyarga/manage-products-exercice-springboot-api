package com.manage.products.utils;

import com.bazaarvoice.jolt.JsonUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.manage.products.dto.ProductDto;
import com.manage.products.dto.ProductsSortedAndFilteredForBrandList;
import com.manage.products.model.Product;
import com.manage.products.serviceImpl.ProductServiceImpl;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class ProductsUtils {
    private static final String ON_SALE = "ON SALE";
    private static final String PRODUCTS_FILE_PATH_TO_LOAD = "/listProducts.json";
    private String product;
    private List<Object> listOfProducts;

    public List<Product> sortProductsLoaded(List<Product> productsLoaded) {
        return productsLoaded.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).toList();
    }

    public List<ProductsSortedAndFilteredForBrandList> getProductsSortedAndFilterByBrand(List<Product> allProductsSortedByPrice) {
        return mapToListToReturn(allProductsSortedByPrice);
    }

    public Product mapObjectToProduct(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        return  objectMapper.convertValue(object, Product.class);
    }
    private List<ProductsSortedAndFilteredForBrandList> mapToListToReturn (List<Product> allProductsSortedByPrice) {
        return getAllBrands(allProductsSortedByPrice)
                .stream()
                .map(brand -> mapToProductsFilterList(brand, allProductsSortedByPrice))
                .collect(Collectors.toList());
    }

    public List<Product> loadDataFromResource() {
        try {
            product = IOUtils
                    .toString(Objects.requireNonNull(ProductServiceImpl.class.getResourceAsStream(PRODUCTS_FILE_PATH_TO_LOAD)),
                            StandardCharsets.UTF_8);
            listOfProducts = JsonUtils.jsonToList(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfProducts.stream()
                .map(this::mapObjectToProduct).collect(Collectors.toList());
    }

    private List<String> getAllBrands(List<Product> sortedList) {
        return  sortedList.stream().map(Product::getBrand).sorted().distinct().collect(Collectors.toList());
    }

    private ProductsSortedAndFilteredForBrandList mapToProductsFilterList (String brand, List<Product> allProductsSortedByPrice) {
        List<ProductDto> productsListDto = allProductsSortedByPrice.stream()
                .filter(v -> brand.equals(v.getBrand()))
                .map(this::mapProductFromSortedPriceListToProductForBrand)
                .collect(Collectors.toList());

        return ProductsSortedAndFilteredForBrandList.builder()
                .brandName(brand)
                .productDto(productsListDto)
                .build();
    }

    private ProductDto mapProductFromSortedPriceListToProductForBrand(Product product) {
        return  ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .event(product.isOnSale()? ON_SALE : null)
                .build();
    }
}
