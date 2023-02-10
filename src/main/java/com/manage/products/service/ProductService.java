package com.manage.products.service;

import com.manage.products.dto.ProductsSortedAndFilteredForBrandList;
import com.manage.products.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    // Create a product
    Product createProduct(Product product);

    // Get all products
    List<Product> getAllProducts();

    // Load products data
    List<Product> loadProducts();

    // Load products data
    List<ProductsSortedAndFilteredForBrandList> loadFilterProducts();
}
