package com.practic.model;

import java.util.Objects;
public class Product {
    private int id;
    private String category;
    private String productName;
    private String description;
    private String price;
    private String quantity;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(category, product.category) && Objects.equals(productName, product.productName) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, productName, description, price, quantity);
    }

    public Product() {
    }

    public Product(int id, String category, String productName, String description, String price, String quantity) {
        this.id = id;
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
