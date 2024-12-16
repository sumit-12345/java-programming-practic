package com.practic.dao;

import com.practic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getAllProducts() {
        String query = "SELECT * FROM product";
//        this.jdbcTemplate.query(query,);
        return null;
    }
}
