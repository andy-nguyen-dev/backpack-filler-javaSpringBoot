package com.example.power_reviews.backpack.service;

import com.example.power_reviews.backpack.model.BackpackModel;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BackpackService {

    public List<BackpackModel> fillBackpack(Integer bagSize) {

        // Creating a sample BackpackModel object
//        BackpackModel backpack = new BackpackModel();
//        backpack.setItem("Laptop");
//        backpack.setCount(1);

        return Arrays.asList(
                new BackpackModel("Bag of Apples", 4),
                new BackpackModel("Trail Mix", 1),
                new BackpackModel("Peanut Butter", 1),
                new BackpackModel("Bread", 2)
        );
    }

}
