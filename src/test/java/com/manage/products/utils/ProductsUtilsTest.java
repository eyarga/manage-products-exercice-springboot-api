package com.manage.products.utils;

import com.manage.products.model.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class ProductsUtilsTest {
    @InjectMocks
    private ProductsUtils productsUtils;

    @Test
    public void loadDataFromResource() {
        List<Product> products = productsUtils.loadDataFromResource();
        Assert.assertEquals(10, products.size());
    }
}
