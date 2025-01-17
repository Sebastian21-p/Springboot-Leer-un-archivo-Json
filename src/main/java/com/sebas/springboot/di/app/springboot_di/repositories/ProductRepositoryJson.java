package com.sebas.springboot.di.app.springboot_di.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sebas.springboot.di.app.springboot_di.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ProductRepositoryJson implements IProductRepository{

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(),Product[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter( p ->
                p.getId().equals(id)).findFirst().orElseThrow();
    }
}
