package com.example.power_reviews.backpack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/backpack")
public class controller {

    @GetMapping("/fill")
    public ResponseEntity<Object> getBackpack(@RequestParam int bagSize) {

        if (bagSize < 11) {
            // Return an error response with appropriate status and message
            return ResponseEntity.badRequest().body("Error: bagSize less than 11, can't fit all the items.");
        }

        return ResponseEntity.ok("nice");
    }

}