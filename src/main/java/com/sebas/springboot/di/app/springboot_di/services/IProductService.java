package com.sebas.springboot.di.app.springboot_di.services;

import com.sebas.springboot.di.app.springboot_di.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
