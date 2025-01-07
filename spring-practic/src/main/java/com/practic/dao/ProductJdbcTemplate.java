package com.practic.dao;

import com.practic.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.List;

public class ProductJdbcTemplate {

    private JdbcTemplate jdbcTemplate;

    public ProductJdbcTemplate() {
        DataSource dataSource = new DriverManagerDataSource(
                "jdbc:mysql://localhost:3306/productdb", "root", "root");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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