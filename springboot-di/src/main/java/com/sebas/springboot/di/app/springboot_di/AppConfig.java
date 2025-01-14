package com.sebas.springboot.di.app.springboot_di;

import com.sebas.springboot.di.app.springboot_di.repositories.IProductRepository;
import com.sebas.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean("productJson")
    IProductRepository iProductRepositoryJson(){
        return new ProductRepositoryJson();
    }

}
