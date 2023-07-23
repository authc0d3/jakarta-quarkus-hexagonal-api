package dev.programadorweb.testapi.products.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Long id;
    private String name;
    private String description;
    private float price;
    private int stock;
    private boolean active;
}
