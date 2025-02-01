package com.example.power_reviews.backpack.service;

import com.example.power_reviews.backpack.model.BackpackModel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BackpackService {

    public List<BackpackModel> fillBackpack(Integer bagSize) {

        List<Map<String, Object>> itemsAvailable = List.of(
                Map.of("item", "Bag of Apples", "weight", 5),
                Map.of("item", "Bread", "weight", 1),
                Map.of("item", "Peanut Butter", "weight", 2),
                Map.of("item", "Trail Mix", "weight", 3)
        );

        // Step 1: Add one of each item to the backpack
        List<BackpackModel> backpack = itemsAvailable.stream()
                .map(item -> new BackpackModel((String) item.get("item"), 1))
                .collect(Collectors.toList());

        // Step 2: Subtract 11 from remaining capacity (since we added 1 of each)
        int remainingCapacity = bagSize - itemsAvailable.stream()
                .mapToInt(item -> (int) item.get("weight"))
                .sum();

        // Step 3: Sort items in descending order by weight
        List<Map<String, Object>> sortedItems = itemsAvailable.stream()
                .sorted((a, b) -> Integer.compare((int) b.get("weight"), (int) a.get("weight")))
                .collect(Collectors.toList());

        // Step 4: Fill the bag using the heaviest items first
        for (Map<String, Object> item : sortedItems) {
            if (remainingCapacity <= 0) break; // Stop if no space is left

            String itemName = (String) item.get("item");
            int itemWeight = (int) item.get("weight");

            // Step 4: Determine how many whole items can fit in the remaining capacity
            int maxCount = remainingCapacity / itemWeight;
            if (maxCount > 0) {
                backpack.stream()
                        .filter(b -> b.getItem().equals(itemName))
                        .findFirst()
                        .ifPresent(b -> b.setCount(b.getCount() + maxCount));

                remainingCapacity -= maxCount * itemWeight; // Update remaining capacity
            }
        }

        return backpack;
    }

}
