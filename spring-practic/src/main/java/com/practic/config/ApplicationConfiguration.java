package com.practic.config;

import com.practic.dao.ProductDao;
import lombok.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {
    private String dbUrl = "jdbc:mysql://localhost:3306/javaprojs";
    private String dbUsername = "root";
    private String dbPassword= "Sambit.joshi@01";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(this.dbUrl);
        dataSource.setUsername(this.dbUsername);
        dataSource.setPassword(this.dbPassword);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource());
        return template;
    }
    @Bean
    public ProductDao productDao() {
        ProductDao productDao = new ProductDao(jdbcTemplate());
        return productDao;
    }
}
