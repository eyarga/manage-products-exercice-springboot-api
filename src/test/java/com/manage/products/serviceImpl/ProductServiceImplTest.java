package com.manage.products.serviceImpl;

import com.manage.products.model.Product;
import com.manage.products.repository.ProductRepository;
import com.manage.products.utils.ProductsUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
    @Mock
    private ProductsUtils productsUtils;
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Test
    public void loadProducts() {
        List<Product> products = productServiceImpl.loadProducts();
        when(productsUtils.mapObjectToProduct(any())).thenReturn(new Product());
        when(productRepository.saveAll(any())).thenReturn(List.of(new Product()));
        Assert.assertEquals(0, products.size());
    }
}
