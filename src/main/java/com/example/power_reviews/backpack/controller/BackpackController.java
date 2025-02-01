package com.example.power_reviews.backpack.controller;

import com.example.power_reviews.backpack.model.BackpackModel;
import com.example.power_reviews.backpack.service.BackpackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/backpack")
public class BackpackController {

    private final BackpackService backpackService = new BackpackService();

    @GetMapping("/fill")
    public ResponseEntity<Object> getBackpack(@RequestParam(required = true) Integer bagSize) {

        if (bagSize < 11) {
            return ResponseEntity.badRequest().body("Error: bagSize less than 11, can't fit all the items.");
        }

        List<BackpackModel> filledBackpack = backpackService.fillBackpack(bagSize);
        System.out.println(filledBackpack);
        return ResponseEntity.ok(filledBackpack);
    }

}