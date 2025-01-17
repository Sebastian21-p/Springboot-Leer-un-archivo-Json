package com.sebas.springboot.di.app.springboot_di.services;

import com.sebas.springboot.di.app.springboot_di.models.Product;
import com.sebas.springboot.di.app.springboot_di.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    @Autowired
    private Environment environment;
    @Autowired
    @Qualifier("productJson")
    private IProductRepository repository;

//    public ProductService( IProductRepository repository) {
//        this.repository = repository;
//    }

    public List<Product> findAll(){
        return repository.findAll().stream().map(p ->{
            Double priceTax = p.getPrice()*environment.getProperty("config.price.tax", Double.class);
//           Product newProd = new Product(p.getId(), p.getName(), priceTax.longValue());
            Product newProd = (Product) p.clone();
            newProd.setPrice(priceTax.longValue());
            return newProd;
//            p.setPrice(priceTax.longValue());
//            return p;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id){
        return repository.findById(id);
    }

}
