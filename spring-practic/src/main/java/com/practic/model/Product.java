package com.practic.model;

import lombok.*;

import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Product {
    private int id;
    private String productName;
    private String description;
    private long price;
    private long quantity;
}
