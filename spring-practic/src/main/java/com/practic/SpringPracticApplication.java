package com.practic;

import com.practic.config.ApplicationConfiguration;
import com.practic.dao.ProductDao;
import com.practic.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class SpringPracticApplication
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        ProductDao productDao = context.getBean(ProductDao.class);
        List<Product> allProducts = productDao.getAllProducts();
        for (Product product : allProducts) {
            System.out.println(product);
        }
    }
}

// JDBC Classic Approach
/*
1. JDBC Template
2. Datasource
3. @Bean @Component @Service @Configuration @PropretySource @Value("${}")
4. dao, service, config, model
5. How to place a resource file.
-----------------------------------------------------
1. dependency add in pom.xml
2. application.property file add in java/main/resource
3. ApplicationConfiguration file create with @Configuration @PropertySource @Value @Bean
4. created a model package and corresponding clas. Product
5. In dao package added a class ProductDao with dependency JdbcTemplate
6. query execution [TODO]
7. In main application get access to SpringIOC container using ApplicationContext.
8. Get the bean and display data.
 */













