package com.example.power_reviews.backpack.model;

import lombok.Data;

@Data
public class BackpackModel {
    private String item;
    private Integer count;

    // Constructor for initialization
    public BackpackModel(String item, Integer count) {
        this.item = item;
        this.count = count;
    }
}