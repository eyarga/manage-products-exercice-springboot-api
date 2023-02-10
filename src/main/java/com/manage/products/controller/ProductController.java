package com.manage.products.controller;

import com.manage.products.dto.ProductsSortedAndFilteredForBrandList;
import com.manage.products.model.Product;
import com.manage.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/loadData")
    public List<Product> loadProducts() {
        return productService.loadProducts();
    }

    @GetMapping("/loadFilterData")
    public List<ProductsSortedAndFilteredForBrandList> loadFilterProducts() {
        return productService.loadFilterProducts();
    }
}
