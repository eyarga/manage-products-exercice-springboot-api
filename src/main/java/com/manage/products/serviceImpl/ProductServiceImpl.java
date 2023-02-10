package com.manage.products.serviceImpl;

import com.manage.products.dto.ProductsSortedAndFilteredForBrandList;
import com.manage.products.model.Product;
import com.manage.products.repository.ProductRepository;
import com.manage.products.service.ProductService;
import com.manage.products.utils.ProductsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductsUtils productsUtils;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> loadProducts() {
        List<Product> productsToLoad = productsUtils.loadDataFromResource();
        return productRepository.saveAll(productsToLoad);
    }

    @Override
    public List<ProductsSortedAndFilteredForBrandList> loadFilterProducts() {
        List<Product> allProductsSortedByPrice = productsUtils.sortProductsLoaded(loadProducts());
        return productsUtils.getProductsSortedAndFilterByBrand(allProductsSortedByPrice);
    }
}

