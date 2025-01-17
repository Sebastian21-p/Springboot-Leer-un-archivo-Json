package com.sebas.springboot.di.app.springboot_di.repositories;

import com.sebas.springboot.di.app.springboot_di.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Arrays;
import java.util.List;

@Primary
@Repository("productList")
//@RequestScope
public class ProductRepository implements IProductRepository {

    private List<Product> data;


    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1L, "Corsair H20",300L),
                new Product(2L,"Logitech G520", 500L),
                new Product(3L,"Asus Gaming",1000L)
        );
    }

    @Override
    public List<Product> findAll() {
        return data;
    }
    @Override
    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
