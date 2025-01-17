package com.practic.dao;

import com.practic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public class ProductDao {

    private JdbcTemplate jdbcTemplate;

    public ProductDao() {
    }

    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getAllProducts() {
        String sql = "SELECT * FROM product";

        PreparedStatementCreator preparedStatementCreator = con -> con.prepareStatement(sql);
        PreparedStatementCallback<List<Product>> callback = ps -> {
            List<Product> products = jdbcTemplate.query(sql, new ProductRowMapper());
            return products;
        };

        return jdbcTemplate.execute(preparedStatementCreator, callback);
    }
}
