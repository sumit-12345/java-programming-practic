package com.practic.dao;

import com.practic.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setCategory(rs.getString("category"));
        product.setProductName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getString("price"));
        product.setQuantity(rs.getString("quantity_in_stock"));
        return product;
    }
}